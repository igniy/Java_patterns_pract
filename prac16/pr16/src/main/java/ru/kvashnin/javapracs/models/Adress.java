package ru.kvashnin.javapracs.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "adress")
@Getter
@Setter
@RequiredArgsConstructor
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

    @JsonIgnore
    @ManyToOne
    public Building building;
}
