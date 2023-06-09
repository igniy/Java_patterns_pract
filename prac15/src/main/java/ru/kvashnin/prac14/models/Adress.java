package ru.kvashnin.prac14.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "adress")
@Getter
@Setter
@NoArgsConstructor
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "adressText")
    private String adressText;

    @Column(name = "zipCode")
    private String zipCode;

    public Adress(String adressText, String zipCode) {
        this.adressText = adressText;
        this.zipCode = zipCode;
    }

}
