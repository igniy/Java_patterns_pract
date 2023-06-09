package ru.kvashnin.prac14.models;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@NoArgsConstructor
public class Building {

    private String type;
    private String creationDate;

    private static List<Building> buildings= new ArrayList<>();



    public void addBuildingInList(Building building) {
        buildings.add(building);
    }

    public void deleteBuilding(String type) {
        buildings.removeIf(building -> Objects.equals(building.getType(), type));
    }

    public void fillArray() {
        if (buildings.size() == 0) {
            buildings.add(new Building("MIREA", "01.02.1975"));
            buildings.add(new Building("MGU", "03.08.1956"));
            buildings.add(new Building("HSE", "11.11.1964"));
            buildings.add(new Building("MFTI", "06.10.1970"));
        }
    }

    public Building(String type, String creationDate) {
        this.type = type;
        this.creationDate = creationDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public static List<Building> getBuildings() {
        return buildings;
    }

}
