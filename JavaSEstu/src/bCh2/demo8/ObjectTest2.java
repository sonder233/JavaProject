package bCh2.demo8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ObjectTest2 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "E:\\JavaProject\\JavaSEstu\\src\\bCh2\\StudentObj.txt";
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        ArrayList<Student> list =(ArrayList<Student>) ois.readObject();
        list.forEach(s -> System.out.println(s.toString()));
        ois.close();
    }
}
