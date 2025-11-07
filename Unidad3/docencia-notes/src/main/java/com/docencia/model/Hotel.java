package com.docencia.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="hotel")
public class Hotel {
    
    @Id
    @OneToMany
    @Column(name="id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="address")
    private String address;



    public Hotel() {
    }

    public Hotel(String id) {
        this.id = id;
    }

     public Hotel(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        Hotel other = (Hotel) obj;
        return Objects.equals(id, other.id);
    }

    
}
