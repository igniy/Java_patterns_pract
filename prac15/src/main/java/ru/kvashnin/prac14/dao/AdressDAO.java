package ru.kvashnin.prac14.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.kvashnin.prac14.models.Adress;

import java.util.List;

@NoArgsConstructor
@Component
public class AdressDAO {

    @PersistenceContext
    private EntityManager em;

    public List<Adress> findAll() {
        Session session = em.unwrap(Session.class);
        return session
                .createQuery("SELECT a from Adress a", Adress.class).getResultList();
    }

    @Transactional
    public void save(Adress adress) {
        Session session = em.unwrap(Session.class);
        session.persist(adress);
        session.close();
    }

    @Transactional
    public void delete(String name) {
        Session session = em.unwrap(Session.class);

        String hql = ("From Adress where adressText =: name");

        Object adress = session.createQuery(hql).setParameter("adressText", name).getSingleResult();
        session.remove(adress);

        session.close();
    }





}
