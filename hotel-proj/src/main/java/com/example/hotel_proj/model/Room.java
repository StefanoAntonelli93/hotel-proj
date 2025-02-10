package com.example.hotel_proj.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private String id;
    private String floor;
    private Integer number;

}
// @Entity
// public class User {
// @Id
// @GeneratedValue(generator = "sequence-generator")
// @GenericGenerator(
// name = "sequence-generator",
// strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
// parameters = {
// @Parameter(name = "sequence_name", value = "user_sequence"),
// @Parameter(name = "initial_value", value = "4"),
// @Parameter(name = "increment_size", value = "1")
// }
// )
// private long userId;

// // ...
// }