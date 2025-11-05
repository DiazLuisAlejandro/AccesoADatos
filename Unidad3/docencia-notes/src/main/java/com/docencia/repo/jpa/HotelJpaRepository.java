package com.docencia.repo.jpa;

import java.util.List;

import com.docencia.model.Hotel;
import com.docencia.repo.IHotelRepository;

public class HotelJpaRepository implements IHotelRepository{

    private final IHotelJpaRepository repository;

    public HotelJpaRepository(IHotelJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean exists(String id) {
        return repository.existsById(id);

    }

    @Override
    public Hotel findById(String id) {
        return repository.findById(id).orElse(null);

    }

    @Override
    public Hotel find(Hotel example) {
        return repository.findFirstByName(example.getName()).orElse(null);
    }

    @Override
    public List<Hotel> findAll() {
        return repository.findAll();
    }

    @Override
    public Hotel save(Hotel hotel) {
        return repository.save(hotel);
    }

    @Override
    public boolean delete(String id) {
         if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

   

}
