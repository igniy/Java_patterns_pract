package ru.kvashnin.javapracs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kvashnin.javapracs.models.Building;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {

}
