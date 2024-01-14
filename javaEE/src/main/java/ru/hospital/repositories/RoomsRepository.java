package ru.hospital.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import ru.hospital.models.RoomsEntity;

import java.util.List;

@Stateless
public class RoomsRepository {
    @PersistenceContext
    private EntityManager em;

    public List<RoomsEntity> findAll() {
        return em.createQuery("select i from RoomsEntity i ", RoomsEntity.class).getResultList();
    }

    public List<RoomsEntity> findByIdRoom(int id_hospital) {
        return em.createQuery("select i from RoomsEntity i where i.id_hospital = :id_hospital", RoomsEntity.class)
                .setParameter("id_hospital", id_hospital)
                .getResultList();
    }

    public void persist(RoomsEntity entity) {
        em.persist(entity);
    }

    public void delete(int id_hospital, int id_room) {
        em.createQuery("delete from PatientsEntity where id_room = :id_room").setParameter("id_room", id_room).executeUpdate();

        RoomsEntity entity = (RoomsEntity) em.createQuery("select i from RoomsEntity i where i.id_hospital = :value1 and i.id_room = :value2")
                .setParameter("value1", id_hospital)
                .setParameter("value2", id_room)
                .getSingleResult();
        em.remove(entity);
    }
}
