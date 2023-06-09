package ru.kvashnin.prac14.controllers;


import org.springframework.web.bind.annotation.*;
import ru.kvashnin.prac14.dao.AdressDAO;
import ru.kvashnin.prac14.models.Adress;

import java.util.List;

@RestController
@RequestMapping("/a")

public class AdressController {

    private final AdressDAO dao;

    public AdressController(AdressDAO dao){
        this.dao = dao;
    }

    @GetMapping()
    public List<Adress> getF() {
        return dao.findAll();
    }

    @PostMapping("/add")
    public void addF(@RequestBody Adress newAdress) {
        dao.save(newAdress);
    }

    @DeleteMapping("/delete/{adressText}")
    public void deleteF(@PathVariable("adressText") String adressText) {
        dao.delete(adressText);
    }

}
