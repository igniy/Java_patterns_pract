package ru.kvashnin.javapracs.controllers;

import org.springframework.web.bind.annotation.*;
import ru.kvashnin.javapracs.dao.BuildingDAO;
import ru.kvashnin.javapracs.models.Building;

import java.util.List;

@RestController
@RequestMapping("/b")
public class BuildingController {

    private final BuildingDAO dao;

    public BuildingController(BuildingDAO dao) {
        this.dao = dao;
    }

    @GetMapping()
    public List<Building> getF() {
        return dao.findAll();
    }

    @PostMapping("/add")
    public void addF(@RequestBody Building building) {
        dao.save(building);
    }

    @DeleteMapping("/{type}")
    public void deleteF(@PathVariable("type") String type) {dao.delete(type);
    }

}
