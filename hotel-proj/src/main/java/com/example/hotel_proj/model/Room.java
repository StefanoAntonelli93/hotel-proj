package com.example.hotel_proj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
@Table(name = "room")
public class Room {

    // @Column(name = "id", nullable = false, length = 6)
    // @Pattern(regexp = "\\d{6}", message = "L'ID deve essere esattamente di 6
    // cifre") // id 6 cifre
    @Id
    private String id;
    private String floor;
    private String number;
    private boolean isSuite;

    // costructor
    public Room(String floor, String number, boolean isSuite) {

        this.floor = floor;
        this.number = number;
        this.isSuite = isSuite;

    }

    // getter setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public boolean getIsSuite() {
        return isSuite;
    }

    public void setIsSuite(boolean isSuite) {
        this.isSuite = isSuite;
    }

    // genero id prima di persistere l'oggettos
    @PrePersist
    public void generateId() {
        if (this.id == null) {
            this.id = "F" + floor + "N" + number;
            System.out.println("Generated ID: " + this.id);
        }
    }

    // to string convertion
    @Override
    public String toString() {
        return "People [id=" + id + ", floor=" + floor + ", number=" + number + ",isSuite" + isSuite + "]";
    }
}
