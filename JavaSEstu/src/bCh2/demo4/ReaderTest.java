package bCh2.demo4;

import java.io.FileReader;
import java.io.IOException;

public class ReaderTest {
    public static void main(String[] args) throws IOException {
        String chineseTxtPath = "E:\\JavaProject\\JavaSEstu\\src\\bCh2\\demo4\\chinese.txt";
        FileReader fileReader = new FileReader(chineseTxtPath);
        //空参read方法
//        int ch;
//        while ((ch = fileReader.read()) != -1){
//            System.out.print((char)ch);
//        }
        //带参read方法
        char[] chars = new char[2];
        int len;
        while ((len = fileReader.read(chars)) != -1){
            String word = new String(chars,0,len);
            System.out.print(word);
        }

        fileReader.close();

    }
}
