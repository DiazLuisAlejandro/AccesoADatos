package com.docencia.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import com.docencia.model.Room;
import com.docencia.repo.jpa.RoomJpaRepository;

@SpringBootTest
@ActiveProfiles("test")
public class RoomJpaRepositoryTest {

    @Autowired
    private RoomJpaRepository roomRepository;

    private Room baseRoom;

    @BeforeEach
    void beforeEach() {
        Room r = new Room();
        r.setNumber("27");
        r.setPricePerNight(100);
        r.setHotelId("H1");
        r.setType("single");
        baseRoom = roomRepository.save(r);

        assertThat(baseRoom.getId()).isNotNull();
    }
    @AfterEach
    void AfterEach(){
        roomRepository.delete(baseRoom.getId());
    }

    @Test
    @Transactional
    void testDelete() {
        String id = baseRoom.getId();

        boolean borrada = roomRepository.delete(id);

        assertThat(borrada).isTrue();
        assertThat(roomRepository.exists(id)).isFalse();
        assertThat(roomRepository.findById(id)).isNull();
    }

    @Test
    @Transactional
    void createReadFindByIdTest() {
        String id = baseRoom.getId();

        Room roomEncontrado = roomRepository.findById(id);
        assertThat(roomEncontrado).isNotNull();
        assertThat(roomEncontrado.getNumber()).isEqualTo("27");
        assertThat(roomEncontrado.getPricePerNight()).isEqualTo(100);
        assertThat(roomEncontrado.getType()).isEqualTo("single");
        assertThat(roomEncontrado.getHotelId()).isEqualTo("H1");

        Room buscadaPorNumero = roomRepository.find(roomEncontrado);
        assertThat(buscadaPorNumero).isNotNull();
        assertThat(buscadaPorNumero.getId()).isEqualTo(id);
    }

    @Test
    @Transactional
    void testExistsTest() {
        assertTrue(roomRepository.exists(baseRoom.getId()));
    }

    @Test
    @Transactional
    void testFindTest() {
        assertNotNull(roomRepository.find(baseRoom));
    }

    @Test
    @Transactional
    void testFindAll() {
        List<Room>rooms=roomRepository.findAll();
        assertEquals(roomRepository.findAll(),rooms);
    }

    @Test
    @Transactional
    void testFindById() {
        Room room=new Room(baseRoom.getId());
        Room room2=roomRepository.findById(baseRoom.getId());
        assertTrue(room2.equals(room));
    }

    @Test
    @Transactional
    void saveTest(){
        Room room=new Room(baseRoom.getId(), "double", "13",89,"H1");
        room=roomRepository.save(room);
        assertTrue(baseRoom.equals(room));
        assertEquals(room.getType(),"double");
        assertEquals(room.getNumber(),"13");
        assertEquals(room.getPricePerNight(), 89);
        assertEquals(room.getHotelId(), "H1");
    }

    @Test
    @Transactional
    void saveTest2(){
        Room room=new Room();
        room=roomRepository.save(room);
        assertNotNull(room);
        
    }
    
}
