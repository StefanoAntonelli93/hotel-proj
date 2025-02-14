package com.example.hotel_proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel_proj.entity.Room;
import com.example.hotel_proj.repo.RoomRepository;

@Service
public class RoomService {
    private final RoomRepository repository;
    private final RoomIdGeneratorService idGeneratorService;

    @Autowired
    public RoomService(RoomRepository repository, RoomIdGeneratorService idGeneratorService) {
        this.repository = repository;
        this.idGeneratorService = idGeneratorService;
    }

    // create room
    public Room createRoom(Integer floor, Integer number, boolean isSuite) {
        Room room = new Room(floor, number, isSuite);
        room.setId(idGeneratorService.generateRoomId(room)); // generate id
        return repository.save(room);

    }

    public List<Room> getAllRooms() {
        return repository.findAll();
    }

    public Room getRoomById(String id) {
        return repository.findById(id)
                .orElse(null);
    }

    public void addRoom(Room room) {
        repository.save(room);
    }

    public void updateRoom(Room room) {
        repository.save(room);
    }

    public boolean deleteRoom(String id) {
        repository.deleteById(id);
        return true;
    }

}
