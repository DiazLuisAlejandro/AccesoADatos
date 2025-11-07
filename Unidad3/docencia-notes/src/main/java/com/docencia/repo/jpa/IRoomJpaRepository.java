package com.docencia.repo.jpa;

import com.docencia.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoomJpaRepository extends JpaRepository<Room, String> {

    
    Optional<Room> findFirstByName(String name);

}
