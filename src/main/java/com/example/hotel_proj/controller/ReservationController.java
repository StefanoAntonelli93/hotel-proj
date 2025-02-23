package com.example.hotel_proj.controller;

import com.example.hotel_proj.entity.Reservation;

import com.example.hotel_proj.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    // logger
    private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
    
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
            logger.warn("Reservation in date: {} / {} not found!", checkin, checkout);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        logger.info("Reservation in date: {} / {} found!", checkin, checkout);
        return new ResponseEntity<>(reservations, HttpStatus.OK);

    }

    @PostMapping("/reservations/create")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        service.addReservation(reservation);
        return (reservation != null) ? new ResponseEntity<>(reservation, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/reservations/{id}")
    public void deleteRoom(@PathVariable Long id) {
        service.deleteReservation(id);

    }
}

