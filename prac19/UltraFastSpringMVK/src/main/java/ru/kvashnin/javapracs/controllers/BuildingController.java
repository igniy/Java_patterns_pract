package ru.kvashnin.javapracs.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kvashnin.javapracs.models.Building;
import ru.kvashnin.javapracs.service.BuildingService;

import java.util.List;

@RestController
@RequestMapping("/b")
@RequiredArgsConstructor
public class BuildingController {

    private final BuildingService buildingService;


    @GetMapping()
    public List<Building> getF() {
        return buildingService.findAll();
    }

    @PostMapping("/add")
    public void addF(@RequestBody Building building) {
        buildingService.create(building);
    }

    @DeleteMapping("/{id}")
    public void deleteF(@PathVariable("id") int id) {buildingService.delete(id);
    }

    @GetMapping("/sort_by_type")
    public List<Building> sortByType() {
        return buildingService.sortByType();
    }
}
