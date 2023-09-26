package bCh2.demo2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BigFileCopyTest {
    public static void main(String[] args) throws IOException  {
        //大文件用数组传输
        FileInputStream fin = new FileInputStream("E:\\JavaProject\\JavaSEstu\\src\\bCh2\\demo2\\test.txt");
        FileOutputStream fou = new FileOutputStream("E:\\JavaProject\\JavaSEstu\\src\\bCh2\\demo2\\copy.txt");

        //byte[] bytes = new byte[2];
        //abcde
        //注意，如果剩余字节不够填充bytes数组，比如剩一个e，上一次读的是cd，则最后一次读取之后，返回值是1没问题，
        //但是此时bytes数组中存的是ed，这里的d是上次读的，如果越界继续读，则返回值为-1，bytes依然为ed，因为没人覆盖
        byte[] bytes = new byte[1024*1024*5];//5MB的缓冲区
        int len ;//每次读取的长度,尽可能填满数组，如果不满，则返回实际读取，若没有了，则返回-1
        while ((len = fin.read(bytes)) != -1){
            fou.write(bytes,0,len);//注意这里也要说明写入多少个字节，因为上述原因
        }
        fou.close();
        fin.close();


    }
}
