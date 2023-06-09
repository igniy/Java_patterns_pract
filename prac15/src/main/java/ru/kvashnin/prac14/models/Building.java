package ru.kvashnin.prac14.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Getter
@Setter
@Table(name = "building")
@NoArgsConstructor

public class Building{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type")
    private String type;

    @Column(name = "creation_data")
    private String creationDate;

    public Building(String type, String creationDate) {
        this.type = type;
        this.creationDate = creationDate;
    }
}
