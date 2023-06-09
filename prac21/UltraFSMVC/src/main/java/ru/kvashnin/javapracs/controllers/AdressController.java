package ru.kvashnin.javapracs.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kvashnin.javapracs.models.Adress;
import ru.kvashnin.javapracs.models.Building;
import ru.kvashnin.javapracs.service.AdressService;
import ru.kvashnin.javapracs.service.EmailService;

import java.util.List;

@RestController
@RequestMapping("/a")
@RequiredArgsConstructor
public class AdressController {

    //private final AdressDAO dao;

    private final AdressService adressService;

    private final EmailService emailService;

    @GetMapping()
    public List<Adress> getF() {
        return adressService.findAll();
    }

    @PostMapping("/add")
    public void addF(@RequestBody Adress newAdress) {
        adressService.create(newAdress);
        emailService.sendAddAdressEmail(newAdress);
    }

    @DeleteMapping("/{id}")
    public void deleteF(@PathVariable("id") int id) {
        adressService.delete(id);
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
