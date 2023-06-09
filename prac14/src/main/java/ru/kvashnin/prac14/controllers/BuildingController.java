package ru.kvashnin.prac14.controllers;

import org.springframework.web.bind.annotation.*;
import ru.kvashnin.prac14.models.Building;

import java.util.List;

@RestController
@RequestMapping("/b")
public class BuildingController {

    private final Building building;

    public BuildingController(Building building) {
        this.building = building;
    }

    @GetMapping()
    public List<Building> getF() {
        building.fillArray();
        return Building.getBuildings();
    }

    @PostMapping("/add")
    public void addF(@RequestBody Building building) {
        building.addBuildingInList(building);
    }

    @DeleteMapping("/delete/{type}")
    public void deleteF(@PathVariable("type") String type) {building.deleteBuilding(type);
    }

}
