package ru.hospital.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.hospital.models.PatientsEntity;

import java.util.List;

@Stateless
public class PatientsRepository {
    @PersistenceContext
    private EntityManager em;

    public List<PatientsEntity> findAll() {
        return em.createQuery("select i from PatientsEntity i",
                PatientsEntity.class).getResultList();
    }

    public PatientsEntity findByIdCard(int id) {
        return em.createQuery("select i from PatientsEntity i where i.id = :id",
                        PatientsEntity.class).setParameter("id", id)
                .getSingleResult();
    }

    public List<PatientsEntity> findByIdHospital(int id) {
        return em.createQuery("select i from PatientsEntity i where i.id_hospital = :id",
                        PatientsEntity.class).setParameter("id", id)
                .getResultList();
    }

    public void persist(PatientsEntity entity) {
        em.persist(entity);
    }

    public void delete(int patientId) {
        PatientsEntity entity = em.find(PatientsEntity.class, patientId);
        em.remove(entity);
    }
}