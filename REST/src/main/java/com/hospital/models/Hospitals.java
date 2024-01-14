package com.hospital.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "hospitals")
public class Hospitals {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "university")
    private String university;

    @Column(name = "id_hospital")
    private int id_hospital;
}
