package pract5;

public class Test {
    public static void main(String[] args) {
        Singleton1 obj1 = Singleton1.getInstance();
        Singleton2 obj2 = Singleton2.getInstance();
        Singleton3 obj3 = Singleton3.getInstance();

        //System.out.println(obj1 == obj2);

        obj1.doSomething();
        obj2.doSomething();
        obj3.doSomething();
    }
}
