package com.example.hotel_proj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel_proj.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, String> {

}
