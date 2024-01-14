package com.hospital.controller;

import com.hospital.models.Hospitals;
import com.hospital.models.EventType;
import com.hospital.models.Model;
import com.hospital.repos.HospitalRepository;
import com.hospital.services.senders.JmsSenderService;
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

    @Autowired
    JmsSenderService jmsSenderService;

    @GetMapping("/hospital")
    public Iterable<Hospitals> getHospital() {
        return hospitalRepository.findAll();
    }

    @GetMapping("/hospital/{id}")
    public @ResponseBody Optional<Hospitals> getHospital(@PathVariable int id) {
        return hospitalRepository.findById(id);
    }

    @PostMapping("/hospital")
    public @ResponseBody Hospitals createHospital(@RequestBody Hospitals Hospital) {
        var hospital = hospitalRepository.save(Hospital);
        jmsSenderService.sendEvent(hospital, EventType.CREATE, Model.Hospitals);
        return hospital;
    }

    @DeleteMapping("/hospital/{id}")
    public @ResponseBody void deleteHospital(@PathVariable int id) {
        var hospital = hospitalRepository.findById(id);
        if (hospital.isPresent()){
            jmsSenderService.sendEvent(hospital, EventType.DELETE, Model.Hospitals);
            hospitalRepository.deleteById(id);
        }
    }


    @PutMapping("/hospital/{id}")
    public @ResponseBody Hospitals updateHospital(@RequestBody Hospitals newHospital, @PathVariable Integer id) {
        jmsSenderService.sendEvent(hospitalRepository.findById(id), EventType.UPDATE, Model.Hospitals);

        return hospitalRepository.findById(id)
                .map(hospitals -> {
                    hospitals.setId_hospital(newHospital.getId_hospital());
                    return hospitalRepository.save(hospitals);
                })
                .orElseGet(() -> {
                    return hospitalRepository.save(newHospital);
                });
    }
}
