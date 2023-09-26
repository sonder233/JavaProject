package bCh2.demo7;

import java.io.*;

public class ConvertStreamTest {
    public static void main(String[] args) throws IOException {
        //利用字节流一次读一整行，并且不能出现乱码
        String path = "E:\\JavaProject\\JavaSEstu\\src\\bCh2\\chinese.txt";
        BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String line;
        while ((line = bf.readLine()) != null){
            System.out.println(line);
        }
        bf.close();

    }
}
