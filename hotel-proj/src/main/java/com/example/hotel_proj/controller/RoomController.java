package com.example.hotel_proj.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {
    @RequestMapping("/hotel")
    public String greet() {
        return "hello";
    }
}
