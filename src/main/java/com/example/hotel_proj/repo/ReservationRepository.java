package com.example.hotel_proj.repo;

import com.example.hotel_proj.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByUser_Username(String username);

    List<Reservation> findByCheckinBeforeAndCheckoutAfter(LocalDate checkout, LocalDate checkin);

}
