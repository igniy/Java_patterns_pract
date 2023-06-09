package pract8.Stategy;


interface Strategy {
    void execute();
}

class ConcreteStrategy1 implements Strategy {
    @Override
    public void execute() {
        System.out.println("Выполняю действие стратегии 1");
    }
}

class ConcreteStrategy2 implements Strategy {
    @Override
    public void execute() {
        System.out.println("Выполняю действие стратегии 2");
    }
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.execute();
    }
}

public class Client {
    public static void main(String[] args) {
        Strategy strategy1 = new ConcreteStrategy1();
        Strategy strategy2 = new ConcreteStrategy2();

        Context context = new Context(strategy1);
        context.executeStrategy();

        context.setStrategy(strategy2);
        context.executeStrategy();
    }
}
