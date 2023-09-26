package bCh2.FileTest;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyFileTest {
    public static void main(String[] args) {
        test_1();

    }
    static void test_2(){
        File newFile = new File("E:\\JavaProject\\JavaSEstu\\src\\bCh2\\FileTest","newFile.txt");

    }
    static void test_1(){
        String pathStr = "E:\\JavaProject\\JavaSEstu\\src\\bCh2\\FileTest";
        //重命名
        File file = new File(pathStr,"chinese.txt");
        File newNameFile = new File(pathStr,"newName.txt");
        boolean renameResult = file.renameTo(newNameFile);
        System.out.println(renameResult);
    }
    static void test(){
        String pathStr = "E:\\JavaProject\\JavaSEstu\\src\\bCh2\\FileTest\\chinese.txt";
        //构建path类
        Path path_1 = Paths.get(pathStr);
//        System.out.println(path_1.resolve("test_2"));
//        System.out.println();
        Path path_2 = path_1.resolveSibling("test");
//        System.out.println(path_2.toString());

        //File类
        File file = new File("test.txt");
        System.out.println(file.getAbsolutePath());

        File file_1 = new File("E:\\JavaProject\\JavaSEstu","child.txt");
        System.out.println(file_1.getAbsolutePath());
    }
}
