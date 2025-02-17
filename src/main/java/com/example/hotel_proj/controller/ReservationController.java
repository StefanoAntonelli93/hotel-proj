package com.example.hotel_proj.controller;

import com.example.hotel_proj.entity.Reservation;

import com.example.hotel_proj.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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

    @GetMapping("/reservations/{username}")
    public ResponseEntity<Reservation> getReservationByUsername(@PathVariable String username) {
        Optional<Reservation> reservation = service.findByUsername(username);
        return reservation.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/reservations/search")
    public ResponseEntity<List<Reservation>> getReservationsByPeriod(
            @RequestParam("checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkin,
            @RequestParam("checkout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkout) {

        List<Reservation> reservations = service.findReservationsByPeriod(checkin, checkout);
        if (reservations.isEmpty()) {
            System.out.println("reservation in date: " + checkin + " / " + checkout + " not found!");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        System.out.println("reservation in date: " + checkin + " / " + checkout + " found!");
        return new ResponseEntity<>(reservations, HttpStatus.OK);

    }

}

