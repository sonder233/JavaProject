package bCh2.demo4;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) throws IOException {
        String chineseTxtPath = "E:\\JavaProject\\JavaSEstu\\src\\bCh2\\demo4\\chinese.txt";

        FileWriter fw = new FileWriter(chineseTxtPath,true);//打开续写开关

        fw.write(25105);//第一个字符
        fw.write('\r');//第一行的回车

        fw.write("早上好中国，现在我有冰淇淋！");
        fw.close();
    }
}
