package com.example.hotel_proj.service;

import com.example.hotel_proj.entity.Reservation;
import com.example.hotel_proj.repo.ReservationRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository repository;

    public ReservationService(@Autowired  ReservationRepository repository) {
        this.repository = repository;
    }

    public List<Reservation> getAllReservations() {
        return repository.findAll();
    }

    public Optional<Reservation> getReservationById(Long id) {
        return repository.findById(id);
    }

    public void addReservation(Reservation reservation) {
        repository.save(reservation);
    }

    public boolean deleteReservation(Long id){
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
