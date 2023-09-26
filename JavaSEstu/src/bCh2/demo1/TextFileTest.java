package bCh2.demo1;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class TextFileTest {
    public static void main(String[] args) throws IOException{
        test_4();
    }
    static void test_4()  throws IOException {
        //连续读取字节
        String path = "E:\\JavaProject\\JavaSEstu\\src\\bCh2\\demo1\\test.txt";
        //1.创建对象
        FileInputStream fin = new FileInputStream(path);
        //2.读取数据
        int b1 ;
        while ((b1 = fin.read()) != -1){
            System.out.println((char) b1);
        }
        //3.释放资源
        fin.close();
    }

    static void test_3()  throws IOException {
        String path = "E:\\JavaProject\\JavaSEstu\\src\\bCh2\\demo1\\test.txt";

        //续写,第二个参数设为true即可
        FileOutputStream fou = new FileOutputStream(path,true);

    }
    static void test_2()  throws IOException {
        //换行写数据
        String path = "E:\\JavaProject\\JavaSEstu\\src\\bCh2\\demo1\\test.txt";
        FileOutputStream fou = new FileOutputStream(path);
        String word = "hello world!";
        byte[] arr_1 = word.getBytes();
        fou.write(arr_1);
        //换行符
        String wrap  = "\r\n";
        byte[] arr_2 = wrap.getBytes();
        fou.write(arr_2);

        String words_2  = "good!";
        byte[] arr_3 = words_2.getBytes();
        fou.write(arr_3);
        fou.close();
    }
    static void test_1()  throws IOException {
        String path = "E:\\JavaProject\\JavaSEstu\\src\\bCh2\\demo1\\test.txt";
        byte[] words = {97,98,99,100};
        //如果文件存在，则会清空数据
        FileOutputStream fou = new FileOutputStream(path);
        //这种会清空源文件的数据
//        fou.write(words);
        fou.close();
    }

}
