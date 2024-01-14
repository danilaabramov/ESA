package ru.hospital.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ru.hospital.models.HospitalsEntity;
import ru.hospital.models.dto.HospitalsRequest;

import ru.hospital.repositories.HospitalsRepository;

import java.util.List;

@Stateless
public class HospitalsService {
    @Inject
    private HospitalsRepository hospitalsRepository;

    public List<HospitalsEntity> getAll() {
        return hospitalsRepository.findAll();
    }

    public void create(HospitalsRequest hospital) {
        HospitalsEntity d = new HospitalsEntity(
                hospital.getId_hospital()
        );
        hospitalsRepository.persist(d);
    }

    public void delete(String university, int id_hospital) {
        hospitalsRepository.delete(university, id_hospital);
    }
}
