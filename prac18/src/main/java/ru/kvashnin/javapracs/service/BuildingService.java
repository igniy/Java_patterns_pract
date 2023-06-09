package ru.kvashnin.javapracs.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ru.kvashnin.javapracs.models.Building;
import ru.kvashnin.javapracs.repositories.BuildingRepository;


import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildingService {

    private final BuildingRepository buildingRepository;

    public Building create(Building building) {
        return buildingRepository.save(building);
    }

    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

    public void delete(int id) {
        buildingRepository.deleteById(id);
    }

    @PersistenceContext
    private EntityManager em;

    public List<Building> sortByType() {
        Session session = em.unwrap(Session.class);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Building> buildCriteriaQuery = builder.createQuery(Building.class);
        Root<Building> root = buildCriteriaQuery.from(Building.class);

        buildCriteriaQuery.select(root).orderBy(builder.asc(root.get("type")));
        return session.createQuery(buildCriteriaQuery).getResultList();
    }

}
