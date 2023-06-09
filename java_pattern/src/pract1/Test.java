package pract1;

import java.io.PipedWriter;
import java.util.Scanner;
import java.util.function.Predicate;

public class Test{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        num = sc.nextInt();
        Predicate<Integer> predicate = x -> {
            while (x != 1 && x % 2 == 0 && x > 0) {
                x /= 2;
            }
            if (x==1) return true;
            return false;
        };
        System.out.println(predicate.test(num));
    }
}
