package com.example.hotel_proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel_proj.model.Room;
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

    @GetMapping("/hotel/rooms/room")
    public Room createRoom() {
        Room room = service.createRoom("1A", "15C", false);
        System.out.println("Created Room: " + room); // Log per il debug
        return room;
    }

    @GetMapping("/hotel/rooms")
    public List<Room> getAllRoom() { // get
        return service.getAllRoom();
    }
}
