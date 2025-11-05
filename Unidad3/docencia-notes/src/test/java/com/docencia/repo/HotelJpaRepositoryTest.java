package com.docencia.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


import com.docencia.model.Hotel;

@SpringBootTest
@ActiveProfiles("test")
public class HotelJpaRepositoryTest {


     @Autowired
    private IHotelRepository hotelRepository;

    private Hotel baseHotel; 
    
    @BeforeEach
    @Transactional
    void beforeEach() {
        Hotel h = new Hotel();
        h.setId("H2");
        h.setName("Hotel prueba");
        h.setAddress("direccion prueba");

        baseHotel = hotelRepository.save(h);

        assertThat(baseHotel.getId()).isNotNull();
    }


    

    @Test
    @Transactional
    void testDelete() {
        String id = baseHotel.getId();

        boolean borrada = hotelRepository.delete(id);

        assertThat(borrada).isTrue();
        assertThat(hotelRepository.exists(id)).isFalse();
        assertThat(hotelRepository.findById(id)).isNull();
    }

    @Test
    void testExists() {

    }

    @Test
    void testFind() {

    }

    @Test
    void testFindAll() {

    }

    @Test
    void testFindById() {

    }

    @Test
    void testSave() {

    }
}
