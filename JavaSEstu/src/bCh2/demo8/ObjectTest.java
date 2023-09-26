package bCh2.demo8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ObjectTest {
    public static void main(String[] args) throws IOException {
        Student stu_1 = new Student("张三",26,"沈阳大街");
        Student stu_2 = new Student("李四",19,"滨江道");
        Student stu_3 = new Student("王五",31,"天津站");

        String path = "E:\\JavaProject\\JavaSEstu\\src\\bCh2\\StudentObj.txt";

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        ArrayList<Student> list = new ArrayList<>();
        list.add(stu_1);
        list.add(stu_2);
        list.add(stu_3);
        oos.writeObject(list);

        oos.close();
    }
}
