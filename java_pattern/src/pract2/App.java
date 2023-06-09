package pract2;

import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class App {
    public static void printList(Stream humans){
        humans.forEach(System.out::println);
    }
    public void start(List<Human> humans){
        Stream<Human> stream = humans.stream();
        System.out.println("Before:");
        App.printList(stream);
        System.out.println("After:");
        String str =  humans.stream()
                .sorted(Comparator.comparing(Human::getFirstName).reversed())
                .filter(x -> x.age>20)
                .limit(3)
                .map(x -> x.firstName)
                .reduce("",(a,b)->a+" "+b);
        System.out.println(str);
    }
}
