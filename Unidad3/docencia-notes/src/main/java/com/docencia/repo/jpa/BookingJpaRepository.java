package com.docencia.repo.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.docencia.model.Booking;
import com.docencia.repo.IBookingRepository;

import jakarta.transaction.Transactional;

@Repository
public class BookingJpaRepository implements IBookingRepository{

    private final IBookingJpaRepository repository;

    public BookingJpaRepository(IBookingJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean exists(String id) {
        return repository.existsById(id);

    }

    @Override
    public Booking findById(String id) {
        return repository.findById(id).orElse(null);

    }

    @Override
    public Booking find(Booking example) {
        return repository.findFirstByCheckIn(example.getCheckIn()).orElse(null);
    }

    @Override
    public List<Booking> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Booking save(Booking booking) {
        if(booking.getId()==null|| booking.getId().isBlank()){
            booking.setId(UUID.randomUUID().toString());
        }
        return repository.save(booking);
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
