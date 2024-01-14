package com.hospital.repos;

import com.hospital.models.Hospitals;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospitals, Integer> {

}
