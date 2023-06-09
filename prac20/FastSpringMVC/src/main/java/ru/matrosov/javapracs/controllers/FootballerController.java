package ru.matrosov.javapracs.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.matrosov.javapracs.models.Footballer;
import ru.matrosov.javapracs.models.Team;
import ru.matrosov.javapracs.service.FootballerService;

import java.util.List;


@RestController
@RequestMapping("/f")
@RequiredArgsConstructor
public class FootballerController {

    private final FootballerService footballerService;

    @GetMapping()
    public List<Footballer> getF() {
        return footballerService.findAll();
    }

    @PostMapping("/add")
    public void addF(@RequestBody Footballer newFootballer) {
        footballerService.create(newFootballer);
    }

    @DeleteMapping("/delete/{name}")
    public void deleteF(@PathVariable("name") int id) {
        footballerService.delete(id);
    }

    @GetMapping("/{footId}/team")
    public Team getFootTeam(@PathVariable("footId") int footId) {
        return footballerService.getTeamByFoot(footId);
    }

    @GetMapping("/sort_by_firstname")
    public List<Footballer> sortFootByFirstName() {
        return footballerService.sortFootByFirstName();
    }

    @GetMapping("/sort_by_lastname")
    public List<Footballer> sortFootByLastName() {
        return footballerService.sortFootByLastName();
    }
//
//    @GetMapping("/dog/sort_by_name")
//    public List<Dog> getSortedByNameDogs() {
//        return dogService.sortDogsByName();
//    }
//
//    @GetMapping("/sort_by_middle_name")
//    public List<Student> getSortedStudentsByMiddleName() {
//        return studentService.sortStudentByMiddleName();
//    }
//
//    @GetMapping("/sort_by_first_name")
//    public List<Student> getSortedStudentsByFirstName() {
//        return studentService.sortStudentByFirstName();
//    }
//
//    @GetMapping("/sort_by_last_name")
//    public List<Student> getSortedStudentsByLastName() {
//        return studentService.sortStudentByLastName();
//    }

}
