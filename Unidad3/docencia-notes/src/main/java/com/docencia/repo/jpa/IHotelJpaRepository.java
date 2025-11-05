package com.docencia.repo.jpa;

import com.docencia.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IHotelJpaRepository extends JpaRepository<Hotel, String> {

    
    Optional<Hotel> findFirstByName(String name);

}
