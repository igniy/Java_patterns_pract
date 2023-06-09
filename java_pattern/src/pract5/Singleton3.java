package pract5;

public class Singleton3 {
    private Singleton3() {

    }

    private static class SingletonHolder {
        private static final Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.instance;
    }
    public void doSomething() {
        System.out.println("We run it - 3");
    }
}
