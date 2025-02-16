package com.example.hotel_proj.controller;

import com.example.hotel_proj.entity.Reservation;

import com.example.hotel_proj.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReservationController {
    private final ReservationService service;

    public ReservationController(@Autowired ReservationService service) {
        this.service = service;
    }

    @PostMapping("/reservations/create")
    public Reservation createReservation(@RequestParam Long userId,
                                         @RequestParam String roomId,
                                         @RequestParam String checkin,
                                         @RequestParam String checkout,
                                         @RequestParam String status) {
        System.out.println("Received parameters: userId=" + userId + ", roomId=" + roomId +
                ", checkin=" + checkin + ", checkout=" + checkout + ", status=" + status);

        try {
            LocalDate checkinDate = LocalDate.parse(checkin);
            LocalDate checkoutDate = LocalDate.parse(checkout);
            return service.createReservation(userId, roomId, checkinDate, checkoutDate, status);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid date format: " + e.getMessage());
        }


    }
    @GetMapping("/reservations")
    public List<Reservation> getAllReservations() { // get
        return service.getAllReservations();
    }

}
