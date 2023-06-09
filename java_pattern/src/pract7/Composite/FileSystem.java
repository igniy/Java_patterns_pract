package pract7.Composite;

import java.util.ArrayList;
import java.util.List;

interface FileSystemComponent {
    void display();
}

class File implements FileSystemComponent {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("File: " + name);
    }
}

class Directory implements FileSystemComponent {
    private String name;
    private List<FileSystemComponent> components = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public void display() {
        System.out.println("Directory: " + name);
        for (FileSystemComponent component : components) {
            component.display();
            //System.out.println('#');
        }
    }
}

public class FileSystem {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        Directory dir1 = new Directory("dir1");
        Directory dir2 = new Directory("dir2");
        File file1 = new File("file1");
        File file2 = new File("file2");
        File file3 = new File("file3");

        root.addComponent(dir1);
        root.addComponent(dir2);

        dir1.addComponent(file1);
        dir1.addComponent(file2);

        dir2.addComponent(file3);

        root.display();
    }
}
