package com.docencia.model;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
    
    @Id
    @Column(name="id")
    private String id;

    @Column(name="check_in")
    private String checkIn;

    @Column(name="check_out")
    private String checkOut;

    @OneToOne
    @JoinColumn(name="guest_id")
    private String guestId;

    @OneToOne
    @JoinColumn(name = "room_id")
    private String roomId;

    

    public Booking() {
    }

    public Booking(String id) {
        this.id = id;
    }

    public Booking(String id, String checkIn, String checkOut, String guestId, String roomId) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guestId = guestId;
        this.roomId = roomId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getGuestId() {
        return guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Booking other = (Booking) obj;
        return Objects.equals(id, other.id);
    }

}
