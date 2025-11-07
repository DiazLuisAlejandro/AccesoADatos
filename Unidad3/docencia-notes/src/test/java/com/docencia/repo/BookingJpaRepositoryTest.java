package com.docencia.repo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

import com.docencia.model.Booking;
import com.docencia.repo.jpa.BookingJpaRepository;


@SpringBootTest
@ActiveProfiles("test")
public class BookingJpaRepositoryTest {

    @Autowired
    private BookingJpaRepository bookingRepository;

    private Booking baseBooking;

    final LocalDate localDate=LocalDate.parse("2025-17-11", DateTimeFormatter.ofPattern("yyyy-DD-mm"));
    
    final LocalDate localDate2=LocalDate.parse("2025-10-11", DateTimeFormatter.ofPattern("yyyy-DD-mm"));


    @BeforeEach
    void beforeEach() {
        Booking b = new Booking();
        b.setCheckIn("2025-10-11");
        b.setCheckOut("2025-17-11");
        b.setGuestId("7");
        b.setRoomId("13");

        baseBooking = bookingRepository.save(b);

        assertThat(baseBooking.getId()).isNotNull();
    }
    @AfterEach
    void AfterEach(){
        bookingRepository.delete(baseBooking.getId());
    }

    @Test
    @Transactional
    void testDelete() {
        String id = baseBooking.getId();

        boolean borrada = bookingRepository.delete(id);

        assertThat(borrada).isTrue();
        assertThat(bookingRepository.exists(id)).isFalse();
        assertThat(bookingRepository.findById(id)).isNull();
    }

    @Test
    @Transactional
    void createReadFindByIdTest() {
        String id = baseBooking.getId();
        
        Booking bookingEncontrado = bookingRepository.findById(id);
        assertThat(bookingEncontrado).isNotNull();
        assertThat(bookingEncontrado.getCheckIn()).isEqualTo(localDate.toString());
        assertThat(bookingEncontrado.getCheckOut()).isEqualTo(localDate2.toString());
        assertThat(bookingEncontrado.getGuestId()).isEqualTo("7");
        assertThat(bookingEncontrado.getRoomId()).isEqualTo("13");


        Booking buscadaPorNombre = bookingRepository.find(bookingEncontrado);
        assertThat(buscadaPorNombre).isNotNull();
        assertThat(buscadaPorNombre.getId()).isEqualTo(id);
    }

    @Test
    @Transactional
    void testExistsTest() {
        assertTrue(bookingRepository.exists(baseBooking.getId()));
    }

    @Test
    @Transactional
    void testFindTest() {
        assertNotNull(bookingRepository.find(baseBooking));
    }

    @Test
    @Transactional
    void testFindAll() {
        List<Booking>bookings=bookingRepository.findAll();
        assertEquals(bookingRepository.findAll(),bookings);
    }

    @Test
    @Transactional
    void testFindById() {
        Booking booking=new Booking(baseBooking.getId());
        Booking booking2=bookingRepository.findById(booking.getId());
        assertTrue(booking2.equals(booking));
    }

    @Test
    @Transactional
    void saveTest(){
        Booking booking=new Booking(baseBooking.getId(), localDate,localDate2,"14","19");
        booking=bookingRepository.save(booking);
        assertTrue(baseBooking.equals(booking));
        assertNotEquals(baseBooking.getCheckIn(), booking.getCheckIn());
        assertNotEquals(baseBooking.getCheckOut(), booking.getCheckOut());
        assertNotEquals(baseBooking.getGuestId(), booking.getGuestId());
        assertNotEquals(baseBooking.getRoomId(), booking.getRoomId());
    }

    @Test
    @Transactional
    void saveTest2(){
        Booking booking=new Booking();
        booking=bookingRepository.save(booking);
        assertNotNull(booking);
        
    }
    
}
