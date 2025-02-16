package com.example.hotel_proj.service;

import com.example.hotel_proj.entity.Room;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RoomIdGeneratorService {

    private final EntityManager entityManager;

    public RoomIdGeneratorService(@Autowired EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String generateRoomId(Room room) {
        String prefix = room.getIsSuite() ? "S" : "N";
        Integer number = room.getNumber();
        Integer floor = room.getFloor();

        if (floor >= 100) {
            throw new IllegalArgumentException("Floor number cannot exceed 2 digits");
        }

        if (number >= 1000) {
            throw new IllegalArgumentException("Room number cannot exceed 3 digits");
        }

        // check query for duplicate rooms
        Query checkQuery = entityManager.createQuery(
                "SELECT COUNT(r) FROM Room r WHERE r.number = :number AND r.floor = :floor"
        );
        checkQuery.setParameter("number", number);
        checkQuery.setParameter("floor", floor);
        Long existingCount = (Long) checkQuery.getSingleResult();

        if (existingCount > 0) {
            throw new IllegalArgumentException("A room with the same number already exists on this floor.");
        }

        String floorStr = (floor < 10) ? String.format("%02d", floor) : floor.toString();


        //query for search last id number
        Query query = entityManager.createQuery(
                "SELECT MAX(CAST(SUBSTRING(r.id, LENGTH(r.id) - 2, 3) AS integer)) " +
                        "FROM Room r WHERE r.floor = :floor"
        );
        query.setParameter("floor", floor);
        Integer lastNumbId = (Integer) query.getSingleResult();

        int nextNumber = (lastNumbId == null) ? 1 : lastNumbId + 1;
        String numberStr = String.format("%03d", nextNumber);

        return prefix + floorStr + numberStr; //id room
    }
}
