package bCh2.demo2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyTest {
    public static void main(String[] args) throws IOException {
        //小文件这么拷贝
        FileInputStream fin = new FileInputStream("E:\\JavaProject\\JavaSEstu\\src\\bCh2\\demo2\\test.txt");
        FileOutputStream fou = new FileOutputStream("E:\\JavaProject\\JavaSEstu\\src\\bCh2\\demo2\\copy.txt");
        int b;
        while ((b = fin.read()) != -1) {
            fou.write(b);
        }
        fou.close();
        fin.close();
    }
}
