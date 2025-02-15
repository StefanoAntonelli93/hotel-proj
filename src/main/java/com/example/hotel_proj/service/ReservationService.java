package com.example.hotel_proj.service;

import com.example.hotel_proj.entity.Room;
import com.example.hotel_proj.entity.User;
import com.example.hotel_proj.entity.Reservation;
import com.example.hotel_proj.repo.RoomRepository;
import com.example.hotel_proj.repo.UserRepository;
import com.example.hotel_proj.repo.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {


    private final ReservationRepository repository;

    public ReservationService(@Autowired  ReservationRepository repository) {
        this.repository = repository;
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;


    public Reservation createReservation(Long userId, String roomId, LocalDate checkin, LocalDate checkout, String status) {
        // Recupera l'utente dal database
        Optional<User> userOpt = userRepository.findById(userId);

        if (checkin == null || checkout == null) {
            throw new IllegalArgumentException("Check-in e check-out non possono essere nulli");
        }

        if (userOpt.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        User user = userOpt.get();

        // Recupera la stanza dal database
        Optional<Room> roomOpt = roomRepository.findById(roomId);
        if (roomOpt.isEmpty()) {
            throw new IllegalArgumentException("Room not found");
        }
        Room room = roomOpt.get();

        // Crea una nuova prenotazione
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setRoom(room);
        reservation.setCheckin(checkin);
        reservation.setCheckout(checkout);
        reservation.setStatus(status);

        // Salva la prenotazione nel database
        return repository.save(reservation);
    }
    public List<Reservation> getAllReservations() {
        return repository.findAll();
    }

}
