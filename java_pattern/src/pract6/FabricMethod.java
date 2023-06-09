package pract6;

interface Product{
    void doSomething();
}

class productA implements Product{

    @Override
    public void doSomething() {
        System.out.println("Product A is doing some something");
    }
}

class productB implements Product{
    @Override
    public void doSomething() {
        System.out.println("Product B is doing some something");
    }
}

abstract class Creator{

    void doOperations(){
        Product p = createProduct();
        p.doSomething();
    }
    abstract public Product createProduct();
}

class CreatorA extends Creator {

    @Override
    public Product createProduct() {
        return new productA();
    }
}

class CreatorB extends Creator {

    @Override
    public Product createProduct() {
        return new productB();
    }
}
public class FabricMethod {
    public static void main(String[] args) {
        Creator creator = new CreatorA();
        Creator creator2 = new CreatorB();
        creator.doOperations();
        creator2.doOperations();
    }
}
