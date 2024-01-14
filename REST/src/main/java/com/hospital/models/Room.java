package com.hospital.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "rooms")
public class Room {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_room")
    private int id_room;

    @Column(name = "id_hospital")
    private int id_hospital;
}

