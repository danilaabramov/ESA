package com.hospital.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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

    @Column(name = "id_hospital")
    private int id_hospital;
}
