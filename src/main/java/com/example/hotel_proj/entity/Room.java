package com.example.hotel_proj.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "room")
public class Room {

    @Id
    private String id;

    private Integer floor;
    private Integer number;
    private boolean isSuite;


    public Room(Integer floor, Integer number, boolean isSuite) {
        this.floor = floor;
        this.number = number;
        this.isSuite = isSuite;
    }

    public Room() {
    }

    // relation with reservation
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    // GETTER E SETTER
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public boolean getIsSuite() {
        return isSuite;
    }

    public void setIsSuite(boolean isSuite) {
        this.isSuite = isSuite;
    }

    @Override
    public String toString() {
        return "Room [id=" + id + ", floor=" + floor + ", number=" + number + ", isSuite=" + isSuite + "]";
    }


    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
