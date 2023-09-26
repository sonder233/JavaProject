package bCh2.demo6;

import java.io.*;

public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {
        String path = "E:\\JavaProject\\JavaSEstu\\src\\bCh2\\demo6\\buffer_from.txt";
        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new FileWriter(path,true));
        bw.newLine();//这个方法是BufferedWriter独有的，跨平台的换行方法
        bw.write("Hello American !");
        bw.write("I have some apples and bananas!");
        bw.newLine();
        bw.write("Now I dont have any");
        bw.close();
    }
}
