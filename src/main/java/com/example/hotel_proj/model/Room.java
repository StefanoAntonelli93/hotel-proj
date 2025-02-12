package com.example.hotel_proj.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.hibernate.annotations.IdGeneratorType;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
@Table(name = "room")
public class Room {

    // GENERATOR ID
    static class RoomIdGenerator implements IdentifierGenerator {

        @Override
        public Object generate(SharedSessionContractImplementor session, Object object) {
            if (!(object instanceof Room room)) {
                throw new IllegalArgumentException(object + "is not an instance of room"); // se non è istanza di room
                                                                                           // lancia eccezione
            }

            String prefix = room.getIsSuite() ? "S" : "N";

            Integer floor = room.getFloor();
            if (floor >= 100) {
                throw new IllegalArgumentException("Floor number cannot exceed 2 digits");
            }
            String floorStr = (floor < 100) ? String.format("%03d", floor) : floor.toString(); // int non può avere zero
                                                                                               // davanti

            Integer number = room.getNumber();
            if (number >= 1000) {
                throw new IllegalArgumentException("Room number cannot exceed 3 digits");
            }
            String numberStr = (number < 10) ? String.format("%02d", number) : number.toString();

            return prefix + floorStr + numberStr; // stringa composta da "S/N + floor + number"
        }
    }

    @IdGeneratorType(RoomIdGenerator.class)
    @Target({ ElementType.METHOD, ElementType.FIELD })
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RoomIdGenerated {
    }

    @Id
    @RoomIdGenerated // richiamo interfaccia
    private String id;
    private Integer floor;
    private Integer number;
    private boolean isSuite;

    // CONSTRUCTOR
    public Room(Integer floor, Integer number, boolean isSuite) {
        this.floor = floor;
        this.number = number;
        this.isSuite = isSuite;
    }

    // NO ARGS CONSTRUCTOR
    public Room() {
    }

    // GETTER SETTER
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

    // to string convertion
    @Override
    public String toString() {
        return "People [id=" + id + ", floor=" + floor + ", number=" + number + ", isSuite" + isSuite + "]";
    }
}
