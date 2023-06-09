package ru.kvashnin.javapracs.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ru.kvashnin.javapracs.models.Adress;
import ru.kvashnin.javapracs.models.Building;

@Service
@RequiredArgsConstructor
public class AdressService {

    @PersistenceContext
    private EntityManager em;

    public Building getBuildingByAdress(int adressId) {
        Session session = em.unwrap(Session.class);
        return session.createQuery("From Adress where id =: adressId", Adress.class)
                .setParameter("adressId", adressId).getSingleResult().getBuilding();
    }
}
