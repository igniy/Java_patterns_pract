package ru.matrosov.javapracs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.matrosov.javapracs.models.Dog;

@Repository
public interface DogRepository extends JpaRepository<Dog, Integer> {

}
