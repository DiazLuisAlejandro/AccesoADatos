package com.docencia.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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

import com.docencia.model.Guest;
import com.docencia.repo.jpa.GuestJpaRepository;

@SpringBootTest
@ActiveProfiles("test")
public class GuestJpaRepositoryTest {

    @Autowired
    private GuestJpaRepository guestRepository;

    private Guest baseGuest;

    @BeforeEach
    void beforeEach() {
        Guest g = new Guest();
        g.setFullName("Antonio de Triana");
        g.setEmail("correo@prueba");
        g.setPhoneNumber("777 77 77 77");

        baseGuest = guestRepository.save(g);

        assertThat(baseGuest.getId()).isNotNull();
    }
    @AfterEach
    void AfterEach(){
        guestRepository.delete(baseGuest.getId());
    }

    @Test
    @Transactional
    void testDelete() {
        String id = baseGuest.getId();

        boolean borrada = guestRepository.delete(id);

        assertThat(borrada).isTrue();
        assertThat(guestRepository.exists(id)).isFalse();
        assertThat(guestRepository.findById(id)).isNull();
    }

    @Test
    @Transactional
    void createReadFindByIdTest() {
        String id = baseGuest.getId();

        Guest guestEncontrado = guestRepository.findById(id);
        assertThat(guestEncontrado).isNotNull();
        assertThat(guestEncontrado.getFullName()).isEqualTo("Antonio de Triana");
        assertThat(guestEncontrado.getEmail()).isEqualTo("correo@prueba");
        assertThat(guestEncontrado.getPhoneNumber()).isEqualTo("777 77 77 77");

        Guest buscadaPorNombre = guestRepository.find(guestEncontrado);
        assertThat(buscadaPorNombre).isNotNull();
        assertThat(buscadaPorNombre.getId()).isEqualTo(id);
    }

    @Test
    @Transactional
    void testExistsTest() {
        assertTrue(guestRepository.exists(baseGuest.getId()));
    }

    @Test
    @Transactional
    void testFindTest() {
        assertNotNull(guestRepository.find(baseGuest));
    }

    @Test
    @Transactional
    void testFindAll() {
        List<Guest>guests=guestRepository.findAll();
        assertEquals(guestRepository.findAll(),guests);
    }

    @Test
    @Transactional
    void testFindById() {
        Guest guest=new Guest(baseGuest.getId());
        Guest guest2=guestRepository.findById(guest.getId());
        assertTrue(guest2.equals(guest));
    }

    @Test
    @Transactional
    void saveTest(){
        Guest guest=new Guest(baseGuest.getId(), "FullNameTest", "emailTest","phoneTest");
        guest=guestRepository.save(guest);
        assertTrue(baseGuest.equals(guest));
        assertNotEquals(baseGuest.getFullName(), guest.getFullName());
        assertNotEquals(baseGuest.getEmail(), guest.getEmail());
        assertNotEquals(baseGuest.getPhoneNumber(), guest.getPhoneNumber());
    }

    @Test
    @Transactional
    void saveTest2(){
        Guest guest=new Guest();
        guest=guestRepository.save(guest);
        assertNotNull(guest);
        
    }
    
}
