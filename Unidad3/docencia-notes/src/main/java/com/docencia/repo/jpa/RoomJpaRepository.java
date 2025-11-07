package com.docencia.repo.jpa;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.docencia.model.Room;
import com.docencia.repo.IRoomRepository;

import jakarta.transaction.Transactional;

@Repository
public class RoomJpaRepository implements IRoomRepository{

    private final IRoomJpaRepository repository;

    public RoomJpaRepository(IRoomJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean exists(String id) {
        return repository.existsById(id);

    }

    @Override
    public Room findById(String id) {
        return repository.findById(id).orElse(null);

    }

    @Override
    public Room find(Room example) {
        return repository.findFirstByName(example.getNumber()).orElse(null);
    }

    @Override
    public List<Room> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public Room save(Room room) {
        if(room.getId()==null|| room.getId().isBlank()){
            room.setId(UUID.randomUUID().toString());
        }
        return repository.save(room);
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
