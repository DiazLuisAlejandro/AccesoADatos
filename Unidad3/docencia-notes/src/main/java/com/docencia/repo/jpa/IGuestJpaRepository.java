package com.docencia.repo.jpa;

import com.docencia.model.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGuestJpaRepository extends JpaRepository<Guest, String> {

    
    Optional<Guest> findFirstByName(String name);

}
