package com.hospital.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
@Table(name = "patientents")
public class Patient implements Serializable {
    @Id
    @Column(name = "id_card")
    private int id_card;

    @Column(name = "id_hospital")
    private int id_hospital;

    @Column(name = "id_room")
    private int id_room;

    @Column(name = "full_name", unique = true)
    private String full_name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "years")
    private int years;
}

