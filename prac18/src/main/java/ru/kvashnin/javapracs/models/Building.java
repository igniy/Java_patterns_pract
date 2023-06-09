package ru.kvashnin.javapracs.models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;


@Entity
@Getter
@Setter
//@Table(name = "building")
@NoArgsConstructor

public class Building{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "creation_data")
    private String creationDate;

    @OneToMany(mappedBy = "building")
    private List<Adress> adresses;
}
