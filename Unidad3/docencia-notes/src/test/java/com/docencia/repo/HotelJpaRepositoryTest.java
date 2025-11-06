package com.docencia.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;


import com.docencia.model.Hotel;
import com.docencia.repo.jpa.HotelJpaRepository;
import com.docencia.repo.jpa.IHotelJpaRepository;


public class HotelJpaRepositoryTest {


    @Autowired
    private HotelJpaRepository hotelRepository=new HotelJpaRepository(this.iHotelJpaRepository);

    private IHotelJpaRepository iHotelJpaRepository;

    private Hotel baseHotel; 
    
    @BeforeEach
    
    void beforeEach() {
        Hotel h = new Hotel();
        h.setName("Hotel prueba");
        h.setAddress("direccion prueba");

        baseHotel = hotelRepository.save(h);

        assertThat(baseHotel.getId()).isNotNull();
    }


    

    @Test

    void testDelete() {
        String id = baseHotel.getId();

        boolean borrada = hotelRepository.delete(id);

        assertThat(borrada).isTrue();
        assertThat(hotelRepository.exists(id)).isFalse();
        assertThat(hotelRepository.findById(id)).isNull();
    }

    @Test

    void createReadFindByNameTest() {
        String id = baseHotel.getId();

        Hotel leida = hotelRepository.findById(id);
        assertThat(leida).isNotNull();
        assertThat(leida.getName()).isEqualTo("Hotel prueba");
        assertThat(leida.getAddress()).isEqualTo("direccion prueba");

        Hotel buscadaPorNombre = hotelRepository.find(leida);
        assertThat(buscadaPorNombre).isNotNull();
        assertThat(buscadaPorNombre.getId()).isEqualTo(id);
    }

    @Test
    void testExistsTest() {
        assertEquals(hotelRepository, baseHotel);
    }

    @Test
    void testFindTest() {

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
