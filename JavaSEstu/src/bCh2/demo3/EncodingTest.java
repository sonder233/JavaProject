package bCh2.demo3;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class EncodingTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String words = "AI将会统治地球";

        //1.编码
        byte[] bytes_1 = words.getBytes();//idea默认字符集是UTF-8
        System.out.println(Arrays.toString(bytes_1));
        byte[] bytes_2 = words.getBytes("GBK");//设定字符集为GBK（需检查异常）
        System.out.println(Arrays.toString(bytes_2));

        //解码
        String decoding_1 = new String(bytes_1);
        System.out.println(decoding_1);
        String decoding_2 = new String(bytes_2,"GBK");//解码时也要手动指定字符集
        System.out.println(decoding_2);
        //如果编码和解码字符集不相等，则会出现乱码，如下
        String wrongDecoding = new String(bytes_1,"GBK");
        System.out.println(wrongDecoding);
    }
}
