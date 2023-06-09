package pract6;

interface Clone{
    Object clone();
}

class FirstObject implements Clone{

    String name;
    public  FirstObject(String name){
        this.name = name;
    }

    @Override
    public Object clone() {
        return new FirstObject(this.name);
    }

    @Override
    public String toString() {
        return "FirstObject{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class Prototype {
    public static void main(String[] args) {
        FirstObject firstObject = new FirstObject("Test");
        FirstObject copy = (FirstObject) firstObject.clone();
        System.out.println(firstObject.toString());
        System.out.println(copy.toString());
    }

}