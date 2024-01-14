package ru.hospital.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospitals")
public class HospitalsEntity {
    @Id
    @Column(name = "university")
    private String university;

    @Column(name = "id_hospital")
    private int id_hospital;
}
