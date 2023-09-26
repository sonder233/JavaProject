package bCh3.demo1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServiceTest_1 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            //1、创建服务端的ServerSocket，指明自己的端口号
            serverSocket = new ServerSocket(8090);
            //2、调用accept接收到来自于客户端的socket
            socket = serverSocket.accept();
            //3、获取socket的输入流
            is = socket.getInputStream();

            //4、读取输入流中的数据
            //ByteArrayOutputStream的好处是它可以根据数据的大小自动扩充
            byteArrayOutputStream = new ByteArrayOutputStream();
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1){
                byteArrayOutputStream.write(buffer,0,len);
            }
            System.out.println("收到了来自客户端"+socket.getInetAddress().getHostName()+
                    "的消息："+byteArrayOutputStream.toString());
            //5、获取一个输出流，写出回复给客户端
            os = socket.getOutputStream();
            os.write("你好，我是服务端".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {

            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(is != null){
                try {
                    is.close();
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
            if (byteArrayOutputStream != null){
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
