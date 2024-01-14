package ru.hospital.models.dto;

import lombok.Data;

@Data
public class RoomsRequest {
    private int id_hospital;
    private int id_room;
}
