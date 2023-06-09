package ru.kvashnin.javapracs.prac13;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Test {

    @Value("${program.student.name}")
    private String name;

    @Value("${program.student.last_name}")
    private String lastName;

    @Value("${program.student.group}")
    private String group;

    @PostConstruct
    public void testYaml() {
        System.out.println(name);
        System.out.println(lastName);
        System.out.println(group);
    }

}
