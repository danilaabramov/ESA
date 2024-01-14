package ru.hospital.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rooms")
public class RoomsEntity {
    @Id
    @Column(name = "id_room")
    private int id_room;

    @Id
    @Column(name = "id_hospital")
    private int id_hospital;
}


