package com.docencia.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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


}
