package ru.Kvashnin.prac10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.Kvashnin.prac10.models.ConcreteProgrammer;
import ru.Kvashnin.prac10.config.BeanConfig;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        ConcreteProgrammer concreteProgrammer = context.getBean(ConcreteProgrammer.class);
        concreteProgrammer.goCode();
    }
}
