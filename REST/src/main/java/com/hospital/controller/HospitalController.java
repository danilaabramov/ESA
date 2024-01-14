package com.hospital.controller;

import com.hospital.models.Hospitals;
import com.hospital.repos.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(
        value = "api",
        produces = {"application/xml", "application/json"}
)

public class HospitalController {
    @Autowired
    HospitalRepository hospitalRepository;

    @GetMapping("/hospital")
    public Iterable<Hospitals> getHospital() {
        return hospitalRepository.findAll();
    }

    @GetMapping("/hospital/{id_card}")
    public @ResponseBody Optional<Hospitals> gethospital(@PathVariable int id_card) {
        return hospitalRepository.findById(id_card);
    }
    @PostMapping("/hospital/patient")
    public @ResponseBody Hospitals createHospital(@RequestBody Hospitals hospital) {
        return hospitalRepository.save(hospital);
    }

    @DeleteMapping("/hospital/patient/{id_card}")
    public @ResponseBody void deleteHospital(@PathVariable int id_card) {
        hospitalRepository.deleteById(id_card);
    }

    @PutMapping("/hospital/{id}")
    public @ResponseBody Hospitals updateHospital(@RequestBody Hospitals newHospital, @PathVariable Integer id) {
        return hospitalRepository.findById(id)
                .map(hospitals -> {
                    hospitals.setId_hospital(newHospital.getId_hospital());
                    hospitals.setUniversity(newHospital.getUniversity());
                    return hospitalRepository.save(hospitals);
                })
                .orElseGet(() -> {
                    return hospitalRepository.save(newHospital);
                });
    }
}
