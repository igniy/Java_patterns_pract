package ru.kvashnin.prac14.models;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Adress {

    private String adressText;
    private String zipCode;

    private static List<Adress> adresses = new ArrayList<>();

    public Adress(String adressText, String zipCode) {
        this.adressText = adressText;
        this.zipCode = zipCode;
    }

    public void addAdressInlist(Adress adress) {
        adresses.add(adress);
    }

    public void deleteAdress(String adressText) {
        adresses.removeIf(adress -> Objects.equals(adress.getAdressText(), adressText));
    }

    public void fillArray() {
        if (adresses.size() == 0) {
            adresses.add(new Adress("Vernadskyi 78", "100453"));
            adresses.add(new Adress("Lomonosova 1", "125321"));
            adresses.add(new Adress("Lubyanka 32", "102880"));
            adresses.add(new Adress("Dolgoprudnyi 27", "193670"));
        }
    }

    public static List<Adress> getAdresses() {
        return adresses;
    }

}
