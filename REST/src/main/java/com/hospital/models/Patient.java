package com.hospital.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Setter
@RequiredArgsConstructor
@Table(name = "patients")
public class Patient {
    @Id
    @Column(name = "id_card")
    private int id_card;

    @Column(name = "id_hospital")
    private int id_hospital;

    @Column(name = "id_room")
    private int id_room;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "gender")
    private String gender;

    @Column(name = "years")
    private int years;

    public int getId_card() {
        return this.id_card;
    }

    public int getId_hospital() {
        return this.id_hospital;
    }

    public int getId_room() {
        return this.id_room;
    }

    public String getFull_name() {
        return this.full_name;
    }

    public String getGender() {
        return this.gender;
    }

    public int getYears() {
        return this.years;
    }
}

