package bCh2.demo9;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class PrintStreamTest {
    public static void main(String[] args) throws IOException {
        String path = "E:\\JavaProject\\JavaSEstu\\src\\bCh2\\chinese_GBK.txt";
        PrintStream ps = new PrintStream(new FileOutputStream(path), true, StandardCharsets.UTF_8);
        ps.println(97);
        ps.println(true);
        ps.printf("%s爱上了%s","阿珍","阿强");
        ps.close();
    }
}
