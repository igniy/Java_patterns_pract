package ru.kvashnin.prac14.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kvashnin.prac14.models.Building;

import java.util.List;

@NoArgsConstructor
@Component
public class BuildingDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Building> findAll() {
        Session session = em.unwrap(Session.class);
        return session
                .createQuery("SELECT b from Building b", Building.class).getResultList();
    }

    @Transactional
    public void save(Building building) {
        Session session = em.unwrap(Session.class);
        session.persist(building);
        session.close();
    }

    @Transactional
    public void delete(String type) {
        Session session = em.unwrap(Session.class);

        String hql = ("From Building where type =: type");

        Object adress = session.createQuery(hql).setParameter("adressText", type).getSingleResult();
        session.remove(adress);

        session.close();
    }





}
