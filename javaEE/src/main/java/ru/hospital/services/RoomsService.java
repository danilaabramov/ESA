package ru.hospital.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ru.hospital.models.RoomsEntity;
import ru.hospital.models.dto.RoomsRequest;
import ru.hospital.repositories.RoomsRepository;

import java.util.List;

@Stateless
public class RoomsService {
    @Inject
    private RoomsRepository roomsRepository;

    public List<RoomsEntity> getAll() {
        return roomsRepository.findAll();
    }

    public void create(RoomsRequest roomsRequest) {
        RoomsEntity room = new RoomsEntity(
                roomsRequest.getId_room(),
                roomsRequest.getId_hospital()
        );
        roomsRepository.persist(room);
    }

    public void delete(int id_hospital, int id_room) {
        roomsRepository.delete(id_hospital, id_room);
    }
}