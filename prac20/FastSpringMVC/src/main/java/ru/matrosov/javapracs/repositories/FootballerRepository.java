package ru.matrosov.javapracs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.matrosov.javapracs.models.Footballer;


@Repository
public interface FootballerRepository extends JpaRepository<Footballer, Integer> {
}
