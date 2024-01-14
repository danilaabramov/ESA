package ru.hospital.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
public class PatientsEntity {
    @Column(name = "id_hospital")
    private int id_hospital;

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_card")
    private int id;

    @Column(name = "id_room")
    private int id_room;


    @Column(name = "full_name", unique = true)
    private String name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "years")
    private int years;
}

