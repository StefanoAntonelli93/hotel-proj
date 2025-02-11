package com.example.hotel_proj.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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
    @Size(min = 6, max = 6, message = "ID must be excatly 6 characters")
    @Pattern(regexp = "\\w{6}", message = "ID must be contains 6 characters")
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

    public Room() {
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
            if (isSuite == true) {
                this.id = "S" + floor + number;

                while (this.id.length() < 6) { // aggiungo 0 fino ad arrivare a 6
                    this.id += "0";
                }
                if (this.id.length() > 6) {
                    throw new IllegalArgumentException(
                            "Error: ID '" + this.id + "' exceed the six characters allowed!"); // lancio eccezione
                }
                // this.id = this.id.substring(0, 6);// se maggiore di 6 tolgo
                System.out.println("Generated ID: " + this.id);
            } else {
                this.id = "N" + floor + number;

                while (this.id.length() < 6) { // aggiungo 0 fino ad arrivare a 6
                    this.id += "0";
                }
                if (this.id.length() > 6) {
                    throw new IllegalArgumentException(
                            "Error: ID '" + this.id + "' exceed the six characters allowed!");
                }
                // this.id = this.id.substring(0, 6);// se maggiore di 6 tolgo
                System.out.println("Generated ID: " + this.id);
            }

        }
    }

    // to string convertion
    @Override
    public String toString() {
        return "People [id=" + id + ", floor=" + floor + ", number=" + number + ", isSuite" + isSuite + "]";
    }
}
