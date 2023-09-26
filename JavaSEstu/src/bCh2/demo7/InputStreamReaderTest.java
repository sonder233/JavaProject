package bCh2.demo7;

import java.io.*;
import java.nio.charset.Charset;

public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        test_2();
    }
    static void test_2() throws IOException {

    }
    static void test_1() throws IOException {
        //转换字符编码
        String path = "E:\\JavaProject\\JavaSEstu\\src\\bCh2\\chinese_GBK.txt";
//        InputStreamReader isr = new InputStreamReader(new FileInputStream(path),"GBK");
//        int ch;
//        while ((ch = isr.read()) != -1){
//            System.out.println((char)ch);
//        }
//        isr.close();
        //上面的方法被淘汰了
        //jdk11的新方法，输出流同理
        //Charset.forName("GBK")
        FileReader fr =new FileReader(path, Charset.forName("GBK"));
                int ch;
        while ((ch = fr.read()) != -1){
            System.out.println((char)ch);
        }
        fr.close();












    }
}
