package com.docencia.repo.jpa;

import com.docencia.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface IBookingJpaRepository extends JpaRepository<Booking, String> {

    
    Optional<Booking> findFirstByCheckIn(LocalDate fecha);

}
