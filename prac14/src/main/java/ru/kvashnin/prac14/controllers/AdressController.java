package ru.kvashnin.prac14.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kvashnin.prac14.models.Adress;

import java.util.List;

@RestController
@RequestMapping("/a")
@RequiredArgsConstructor
public class AdressController {

    private final Adress adress;

    @GetMapping()
    public List<Adress> getF() {
        adress.fillArray();
        return Adress.getAdresses();
    }

    @PostMapping("/add")
    public void addF(@RequestBody Adress newAdress) {
        adress.addAdressInlist(newAdress);
    }

    @DeleteMapping("/delete/{adressText}")
    public void deleteF(@PathVariable("adressText") String adressText) {
        adress.deleteAdress(adressText);
    }

}
