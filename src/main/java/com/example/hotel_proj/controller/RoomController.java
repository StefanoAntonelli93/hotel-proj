package com.example.hotel_proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/hotel/rooms/create")
    public Room createRoom(@RequestParam Integer floor, @RequestParam Integer number, @RequestParam boolean isSuite) {
        return service.createRoom(floor, number, isSuite);
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
        return (room != null) ? new ResponseEntity<>(room, HttpStatus.CREATED)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/rooms")
    public ResponseEntity<Room> updateRoom(@RequestBody Room room) {
        service.updateRoom(room);
        return (room != null) ? new ResponseEntity<>(room, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable String id) {
        boolean deleted = service.deleteRoom(id);
        if (deleted) {
            return new ResponseEntity<>("Room deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Room not found", HttpStatus.NOT_FOUND);
        }
    }
}
