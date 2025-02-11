package com.example.hotel_proj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    public List<Room> getAllRoom() { // get
        return service.getAllRoom();
    }
}
