package com.example.hotel_proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel_proj.model.Room;
import com.example.hotel_proj.repo.RoomRepository;

@Service
public class RoomService {
    private final RoomRepository repository;

    // autowiring constructor
    public RoomService(@Autowired RoomRepository repository) {
        this.repository = repository;
    }

    // create room
    public Room createRoom(Integer floor, Integer number, boolean isSuite) {
        Room room = new Room(floor, number, isSuite);
        System.out.println("Creating room: " + room);
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
