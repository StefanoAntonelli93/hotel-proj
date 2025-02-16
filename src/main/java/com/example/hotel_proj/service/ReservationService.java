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
    private final UserRepository userRepository;
    private final RoomRepository roomRepository;

    public ReservationService(@Autowired  ReservationRepository repository, UserRepository userRepository, RoomRepository roomRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.roomRepository = roomRepository;
    }

    public Reservation createReservation(Long userId, String roomId, LocalDate checkin, LocalDate checkout, String status) {
        // find user
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        User user = userOpt.get();

        //find room
        Optional<Room> roomOpt = roomRepository.findById(roomId);
        if (roomOpt.isEmpty()) {
            throw new IllegalArgumentException("Room not found");
        }
        Room room = roomOpt.get();

        if (checkin == null || checkout == null) {
            throw new IllegalArgumentException("Check-in and check-out cannot be null");
        }

        // new reservation
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setRoom(room);
        reservation.setCheckin(checkin);
        reservation.setCheckout(checkout);
        reservation.setStatus(status);

        return repository.save(reservation);
    }
    public List<Reservation> getAllReservations() {
        return repository.findAll();
    }

}
