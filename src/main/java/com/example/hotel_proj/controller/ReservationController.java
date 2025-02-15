package com.example.hotel_proj.controller;

import com.example.hotel_proj.entity.Reservation;
import com.example.hotel_proj.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReservationController {

    private final ReservationService service;

    public ReservationController(@Autowired ReservationService service) {
        this.service = service;
    }
    @GetMapping("/reservations")
    public List<Reservation> getAllReservations(){
        return service.getAllReservations();
    }
    @GetMapping("/reservations/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id){
        Optional<Reservation> reservation = service.getReservationById(id);
        return reservation.map(value -> new ResponseEntity<>(value, HttpStatus.OK)) // use map for Optional
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/reservations")
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation){
        service.addReservation(reservation);
        return (reservation != null) ? new ResponseEntity<>(reservation, HttpStatus.OK)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/reservations/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long id) {
        boolean deleted = service.deleteReservation(id);
        if (deleted) {
            return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
    }

}
