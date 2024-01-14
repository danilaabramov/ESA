package ru.hospital.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.hospital.models.HospitalsEntity;
import ru.hospital.models.PatientsEntity;

import java.util.List;

@Stateless
public class HospitalsRepository {
    @PersistenceContext
    private EntityManager em;

    public List<HospitalsEntity> findAll() {
        return em.createQuery("select i from HospitalitoriesEntity i",
                HospitalsEntity.class).getResultList();
    }

    public PatientsEntity findByUniversity(String university) {
        return em.createQuery("select i from HospitalsEntity i where i.university = :university",
                        PatientsEntity.class).setParameter("university", university)
                .getSingleResult();
    }

    public void persist(HospitalsEntity entity) {
        em.persist(entity);
    }

    public void delete(String university, int id_hospital) {
        em.createQuery("delete from PatientsEntity where id_hospital = :id_hospital")
                .setParameter("id_room", id_hospital)
                .executeUpdate();

        em.createQuery("delete from RoomsEntity where id_hospital = :id_hospital")
                .setParameter("id_room", id_hospital)
                .executeUpdate();

        em.createQuery("delete from HospitalitoriesEntity where university = :university")
                .setParameter("university", university)
                .executeUpdate();
    }
}
