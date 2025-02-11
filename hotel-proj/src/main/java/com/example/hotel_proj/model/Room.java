package com.example.hotel_proj.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "room")
public class Room {
    @Id
    @Column(name = "id", nullable = false, length = 6)
    @Pattern(regexp = "\\d{6}", message = "L'ID deve essere esattamente di 6 cifre") // id 6 cifre
    private String id;
    private String floor;
    private String number;

    @Override
    public String toString() {
        return "People [id=" + id + ", floor=" + floor + ", number=" + number + "]";
    }
}
