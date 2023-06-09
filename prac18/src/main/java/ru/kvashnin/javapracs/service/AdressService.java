package ru.kvashnin.javapracs.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ru.kvashnin.javapracs.models.Adress;
import ru.kvashnin.javapracs.models.Building;
import ru.kvashnin.javapracs.repositories.AdressRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdressService {

    private final AdressRepository adressRepository;

    public Adress create(Adress adress) {
        return adressRepository.save(adress);
    }

    public List<Adress> findAll() {
        return adressRepository.findAll();
    }

    public void delete(int id) {
        adressRepository.deleteById(id);
    }
    @PersistenceContext
    private EntityManager em;

    public Building getBuildingByAdress(int adressId) {
        Session session = em.unwrap(Session.class);
        return session.createQuery("From Adress where id =: adressId", Adress.class)
                .setParameter("adressId", adressId).getSingleResult().getBuilding();
    }

    public List<Adress> sortAdressByText(){
        Session session = em.unwrap(Session.class);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Adress> adressCriteriaQuery = builder.createQuery(Adress.class);
        Root<Adress> root = adressCriteriaQuery.from(Adress.class);

        adressCriteriaQuery.select(root).orderBy(builder.asc(root.get("adressText")));
        return session.createQuery(adressCriteriaQuery).getResultList();
    }

    public List<Adress> sortAdressByCode(){
        Session session = em.unwrap(Session.class);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Adress> adressCriteriaQuery = builder.createQuery(Adress.class);
        Root<Adress> root = adressCriteriaQuery.from(Adress.class);

        adressCriteriaQuery.select(root).orderBy(builder.asc(root.get("zipCode")));
        return session.createQuery(adressCriteriaQuery).getResultList();
    }
}
