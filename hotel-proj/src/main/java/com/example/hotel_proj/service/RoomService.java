package com.example.hotel_proj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel_proj.model.Room;
import com.example.hotel_proj.repo.RoomRepository;

@Service
public class RoomService {
    private final RoomRepository repository;

    public RoomService(@Autowired RoomRepository repository) {
        this.repository = repository;
    }

    public List<Room> getAllRoom() {
        return repository.findAll();
    }
}
