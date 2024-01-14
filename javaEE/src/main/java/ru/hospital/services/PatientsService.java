package ru.hospital.services;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import ru.hospital.models.PatientsEntity;
import ru.hospital.models.dto.PatientsRequest;
import ru.hospital.repositories.PatientsRepository;

import java.util.List;

@Stateless
public class PatientsService {
    @Inject
    private PatientsRepository patientsRepository;

    public List<PatientsEntity> getAll() {
        return patientsRepository.findAll();
    }

    public void create(patientsRequest patientsRequest) {
        PatientsEntity patient = new PatientsEntity(
                patientsRequest.getId_hospital(),
                patientsRequest.getId(),
                patientsRequest.getId_room(),
                patientsRequest.getName(),
                patientsRequest.getGender(),
                patientsRequest.getScore(),
                patientsRequest.getYears()
        );
        patientsRepository.persist(patient);
    }

    public void delete(int patientId) {
        patientsRepository.delete(patientId);
    }

}