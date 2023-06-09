package pract6;

import javax.swing.*;
import java.util.Map;

interface TeamFactory{
    Developer getDeveloper();
    Tester getTester();
    Manager getManager();
}

interface Developer{
    void doStuff();
}
interface Tester{
    void doStuff();
}
interface Manager{
    void doStuff();
}

class JavaDeveloper implements Developer{

    @Override
    public void doStuff() {
        System.out.println("Java developer is working");
    }
}

class JavaTester implements Tester{
    @Override
    public void doStuff() {
        System.out.println("Java tester is working");
    }
}

class ProjectManager implements Manager{
    @Override
    public void doStuff() {
        System.out.println("Project manager is working");
    }
}

class RealTeam implements TeamFactory {

    @Override
    public Developer getDeveloper() {
        return new JavaDeveloper();
    }

    @Override
    public Tester getTester() {
        return new JavaTester();
    }

    @Override
    public Manager getManager() {
        return new ProjectManager();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        TeamFactory team = new RealTeam();
        Developer javaDeveloper = team.getDeveloper();
        Tester javaTester = team.getTester();
        Manager projectManager = team.getManager();

        System.out.println("Team start working....");
        javaDeveloper.doStuff();
        javaTester.doStuff();
        projectManager.doStuff();
    }

}
