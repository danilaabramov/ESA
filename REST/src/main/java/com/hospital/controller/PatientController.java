package com.hospital.controller;

import com.hospital.models.Patient;

import com.hospital.repos.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(
        value = "api",
        produces = {"application/xml", "application/json"}
)
public class PatientController {
    @Autowired
    PatientRepository patientRepository;

    @GetMapping("/patient")
    public @ResponseBody Iterable<Patient> getPatient() {
        return patientRepository.findAll();
    }

    @GetMapping("/patient/{id_card}")
    public @ResponseBody Optional<Patient> getPatient(@PathVariable int id_card) {
        return patientRepository.findById(id_card);
    }

    @PostMapping("/patient")
    public @ResponseBody Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @DeleteMapping("/patient/{id_card}")
    public @ResponseBody void deletePatient(@PathVariable int id_card) {
        var patient = patientRepository.findById(id_card);
        if (patient.isPresent()){
            patientRepository.deleteById(id_card);
        }
    }

    @PutMapping("/patient/{id}")
    public @ResponseBody Patient updatePatient(@RequestBody Patient newPatient, @PathVariable Integer id) {
        return patientRepository.findById(id)
                .map(patient -> {
                    if (newPatient.getId_hospital() != 0) {
                        patient.setId_hospital(newPatient.getId_hospital());
                    }
                    if (newPatient.getYears() != 0) {
                        patient.setYears(newPatient.getYears());
                    }
                    return patientRepository.save(patient);
                })
                .orElseGet(() -> {
                    return patientRepository.save(newPatient);
                });
    }
}

