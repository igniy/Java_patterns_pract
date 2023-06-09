package ru.kvashnin.javapracs.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kvashnin.javapracs.dao.AdressDAO;
import ru.kvashnin.javapracs.models.Adress;
import ru.kvashnin.javapracs.models.Building;
import ru.kvashnin.javapracs.service.AdressService;

import java.util.List;

@RestController
@RequestMapping("/a")
@RequiredArgsConstructor
public class AdressController {

    private final AdressDAO dao;

    private final AdressService adressService;

//    public AdressController(AdressDAO dao, AdressService adressService){
//        this.dao = dao;
//        this.adressService = adressService;
//    }

    @GetMapping()
    public List<Adress> getF() {
        return dao.findAll();
    }

    @PostMapping("/add")
    public void addF(@RequestBody Adress newAdress) {
        dao.save(newAdress);
    }

    @DeleteMapping("/{adressText}")
    public void deleteF(@PathVariable("adressText") String adressText) {
        dao.delete(adressText);
    }

    @GetMapping("/{adressId}/building")
    public Building getadressBuilding(@PathVariable("adressId") int adressId) {
        return adressService.getBuildingByAdress(adressId);
    }

    @GetMapping("/sort_by_adress")
    public List<Adress> sortAdressByText() {
        return adressService.sortAdressByText();
    }

    @GetMapping("/sort_by_code")
    public List<Adress> sortAdressByCode() {
        return adressService.sortAdressByCode();
    }


}
