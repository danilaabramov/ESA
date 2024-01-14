package ru.hospital.models.dto;

import lombok.Data;

@Data
public class PatientsRequest {
    private int id_hospitals;
    private int id;
    private int id_room;
    private String name;
    private String gender;
    private float score;
    private int years;
}