package bCh2.demo6;

import java.io.*;

public class BufferedStreamTest {
    public static void main(String[] args) throws IOException {
        String path = "E:\\JavaProject\\JavaSEstu\\src\\bCh2\\demo6\\";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path+"buffer_from.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path+"copy.txt"));
        int b ;
        while ( (b = bis.read()) != -1){
            bos.write(b);
        }
        bos.close();
        bis.close();
    }
}
