package ru.kvashnin.javapracs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kvashnin.javapracs.models.Adress;


@Repository
public interface AdressRepository extends JpaRepository<Adress, Integer> {
}
