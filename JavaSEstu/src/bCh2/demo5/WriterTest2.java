package bCh2.demo5;

import java.io.FileWriter;
import java.io.IOException;

public class WriterTest2 {
    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("E:\\JavaProject\\JavaSEstu\\src\\bCh2\\demo5\\buffer.txt");
        //从缓存区到内存的三种情况：
        //1.缓冲区满了
        //2.flush冲刷
        //3.close
        for (int i = 0; i < 8192; i++) {
            fw.write(97);//97 is 'a'
        }//这里直接塞满缓冲区，缓存区内容就写到文件了

        fw.write("早上好中国");//如果缓存区没满就不会到内存
        fw.flush();//直接冲刷到文件里
        fw.write("现在我有冰淇淋！");
        fw.close();//close()也会直接把缓冲区的内容写到文件

    }
}
