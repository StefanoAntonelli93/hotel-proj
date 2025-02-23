package com.example.hotel_proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.hotel_proj.entity.Room;
import com.example.hotel_proj.service.RoomService;

@RestController
@RequestMapping("/api")
public class RoomController {
    @RequestMapping("/hotel")
    public String greet() {
        return "Welcome to hotel";
    }

    private final RoomService service;

    public RoomController(@Autowired RoomService service) {
        this.service = service;
    }

    @GetMapping("/rooms")
    public List<Room> getAllRooms() { // get
        return service.getAllRooms();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable String id) {
        Room room = service.getRoomById(id);
        return (room != null) ? new ResponseEntity<>(room, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/rooms")
    public ResponseEntity<Room> addRoom(@RequestBody Room room) {
        service.addRoom(room);
        return new ResponseEntity<>(room, HttpStatus.CREATED);

    }
    
    @DeleteMapping("/rooms/{id}")
    public void deleteRoom(@PathVariable String id) {
        service.deleteRoom(id);
    }
}
