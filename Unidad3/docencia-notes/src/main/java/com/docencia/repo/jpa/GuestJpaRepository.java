package com.docencia.repo.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.docencia.model.Guest;
import com.docencia.repo.IGuestRepository;

import jakarta.transaction.Transactional;

@Repository
public class GuestJpaRepository implements IGuestRepository{

    private final IGuestJpaRepository repository;

    public GuestJpaRepository(IGuestJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean exists(String id) {
        return repository.existsById(id);

    }

    @Override
    public Guest findById(String id) {
        return repository.findById(id).orElse(null);

    }

    @Override
    public Guest find(Guest example) {
        return repository.findFirstByName(example.getFullName()).orElse(null);
    }

    @Override
    public List<Guest> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Guest save(Guest guest) {
        if(guest.getId()==null|| guest.getId().isBlank()){
            guest.setId(UUID.randomUUID().toString());
        }
        return repository.save(guest);
    }

    @Override
    @Transactional
    public boolean delete(String id) {
         if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

  
   

}
