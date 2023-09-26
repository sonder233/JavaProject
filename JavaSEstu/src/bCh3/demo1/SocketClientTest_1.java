package bCh3.demo1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientTest_1 {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;
        InputStream is = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            InetAddress inet = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inet,8090);
            os = socket.getOutputStream();
            os.write("Hello!我是客户端".getBytes());
            //4、首先必须通知服务器，我已经输出完毕了，不然服务端不知道什么时候输出完毕
            //服务端的while循环会一直执行，会阻塞
            socket.shutdownOutput();
            //5、获取输入流，用于读取服务端回复的数据
            is = socket.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len ;
            while ((len = is.read(buffer)) != -1){
                byteArrayOutputStream.write(buffer,0,len);
            }
            System.out.println("收到了来自服务端的消息："+byteArrayOutputStream.toString());
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (os != null){
                try {
                    os.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
