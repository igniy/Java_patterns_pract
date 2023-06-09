package pract3;

public class Test {
    public static void S() {
        MySet set1 = new MySet();
        Runnable cot = () -> {
            for (int i = 0; i < 5; i++) {
                set1.add(i);
            }
        };
        Thread thread1 = new Thread(cot);
        Thread thread2 = new Thread(cot);
        thread1.start();
        thread2.start();
    }
    public static void L() {
        MyList<Integer> list = new MyList<>();
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                list.add(i);
            }
        };
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
    }

    public static void main(String[] args) {
        L();
    }
}


