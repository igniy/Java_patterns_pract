package pract2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        List<Human> humans = new ArrayList<>();
        humans.add(new Human(29,"Mark","Kafka", LocalDate.of(1999,12,31),88));
        humans.add(new Human(41,"Charles","Bukowski", LocalDate.of(2000,5,22),59));
        humans.add(new Human(15,"Franz","Kafka", LocalDate.of(1984,3,1),65));
        humans.add(new Human(33,"Haruki","Murakami", LocalDate.of(2003,6,6),76));
        humans.add(new Human(11,"Haruki","Kafka", LocalDate.of(2009,1,6),100));
        humans.add(new Human(66,"Klark","Lin", LocalDate.of(1941,6,22),55));
        App app = new App();
        app.start(humans);
        //App.printList(stream);
        //stream.filter(str -> str.length() > 10).sorted(Comparator.comparingInt(String::length)).forEach(System.out::println);
    }
}
