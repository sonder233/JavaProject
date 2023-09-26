package bCh3.demo2;

import java.io.IOException;
import java.net.*;

public class UDPSender {
    public static void main(String[] args) throws IOException {
        //1、创建一个socket
        DatagramSocket socket = new DatagramSocket();
        InetAddress inet = InetAddress.getLocalHost();
        String msg = "很高兴认识你，冰淇淋！";
        byte[] buffer = msg.getBytes();
        //2、创建一个包（要发送给谁）
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length,inet,9090);
        //3、发送包
        socket.send(packet);
        socket.close();
    }
}
