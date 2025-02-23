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

    public RoomService(@Autowired RoomRepository repository, RoomIdGeneratorService idGeneratorService) {
        this.repository = repository;
        this.idGeneratorService = idGeneratorService;
    }

    public List<Room> getAllRooms() {
        return repository.findAll();
    }

    public Room getRoomById(String id) {
        return repository.findById(id)
                .orElse(null);
    }

    public void addRoom(Room room) {
        room.setId(idGeneratorService.generateRoomId(room));
        repository.save(room);
    }

    public void deleteRoom(String id) {
        repository.deleteById(id);
    }

}
