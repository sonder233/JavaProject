package bCh2.demo8;

import java.io.*;

public class ObjectStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //序列化
        Student student = new Student("张三",23,"朝阳大街");
        String path = "E:\\JavaProject\\JavaSEstu\\src\\bCh2\\StudentObj.txt";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(student);
        oos.close();

        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Student o = (Student) ois.readObject();
        System.out.println(o.getAddress());
        ois.close();
    }
}
