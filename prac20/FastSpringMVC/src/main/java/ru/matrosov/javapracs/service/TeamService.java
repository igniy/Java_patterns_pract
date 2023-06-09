package ru.matrosov.javapracs.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import ru.matrosov.javapracs.models.Team;
import ru.matrosov.javapracs.repositories.TeamRepository;
import ru.matrosov.javapracs.util.LogExecutionTime;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TeamService {

    private final TeamRepository teamRepository;

    public Team create(Team team) {
        log.info("App team");
        return teamRepository.save(team);
    }

    @LogExecutionTime
    public List<Team> findAll() {
        log.info("Find all teams");
        return teamRepository.findAll();
    }

    public void delete(int id) {
        log.info("Delete team");
        teamRepository.deleteById(id);
    }

    @PersistenceContext
    private EntityManager em;

    public List<Team> sortByName() {
        log.info("Sort by name teams");
        Session session = em.unwrap(Session.class);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Team> teamCriteriaQuery = builder.createQuery(Team.class);
        Root<Team> root = teamCriteriaQuery.from(Team.class);

        teamCriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));
        return session.createQuery(teamCriteriaQuery).getResultList();
    }

}
