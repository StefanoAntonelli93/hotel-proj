package com.example.hotel_proj.model;



import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    @Id
    private String id;

    private Integer floor;
    private Integer number;
    private boolean isSuite;

    // COSTRUTTORE
    public Room(Integer floor, Integer number, boolean isSuite) {
        this.floor = floor;
        this.number = number;
        this.isSuite = isSuite;
    }

    // COSTRUTTORE SENZA ARGOMENTI
    public Room() {
    }

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
}
