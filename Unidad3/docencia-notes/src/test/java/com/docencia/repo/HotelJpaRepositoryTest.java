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

import com.docencia.model.Hotel;
import com.docencia.repo.jpa.HotelJpaRepository;

@SpringBootTest
@ActiveProfiles("test")
public class HotelJpaRepositoryTest {

    @Autowired
    private HotelJpaRepository hotelRepository;

    private Hotel baseHotel;

    @BeforeEach
    void beforeEach() {
        Hotel h = new Hotel();
        h.setName("Hotel prueba");
        h.setAddress("direccion prueba");

        baseHotel = hotelRepository.save(h);

        assertThat(baseHotel.getId()).isNotNull();
    }
    @AfterEach
    void AfterEach(){
        hotelRepository.delete(baseHotel.getId());
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
    @Transactional
    void createReadFindByIdTest() {
        String id = baseHotel.getId();

        Hotel hotelEncontrado = hotelRepository.findById(id);
        assertThat(hotelEncontrado).isNotNull();
        assertThat(hotelEncontrado.getName()).isEqualTo("Hotel prueba");
        assertThat(hotelEncontrado.getAddress()).isEqualTo("direccion prueba");

        Hotel buscadaPorNombre = hotelRepository.find(hotelEncontrado);
        assertThat(buscadaPorNombre).isNotNull();
        assertThat(buscadaPorNombre.getId()).isEqualTo(id);
    }

    @Test
    @Transactional
    void testExistsTest() {
        assertTrue(hotelRepository.exists(baseHotel.getId()));
    }

    @Test
    @Transactional
    void testFindTest() {
        assertNotNull(hotelRepository.find(baseHotel));
    }

    @Test
    @Transactional
    void testFindAll() {
        List<Hotel>hoteles=hotelRepository.findAll();
        assertEquals(hotelRepository.findAll(),hoteles);
    }

    @Test
    @Transactional
    void testFindById() {
        Hotel hotel=new Hotel(baseHotel.getId());
        Hotel hotel2=hotelRepository.findById(baseHotel.getId());
        assertTrue(hotel2.equals(hotel));
    }

    @Test
    @Transactional
    void saveTest(){
        Hotel hotel=new Hotel(baseHotel.getId(), "SaveNameTest", "AddressSaveTest");
        hotel=hotelRepository.save(hotel);
        assertTrue(baseHotel.equals(hotel));
        assertNotEquals(baseHotel.getName(), hotel.getName());
        assertNotEquals(baseHotel.getAddress(), hotel.getAddress());
    }

    @Test
    @Transactional
    void saveTest2(){
        Hotel hotel=new Hotel();
        hotel=hotelRepository.save(hotel);
        assertNotNull(hotel);
        
    }
    
}
