package bCh3.demo3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSender implements Runnable {

    DatagramSocket socket = null;
    //创建一个流，用于接收键盘的数据
    BufferedReader bfr = null;
    private String toIp;
    private int toPort;

    public UDPSender(String toIp,int toPort){
        this.toIp = toIp;
        this.toPort = toPort;
        try{
            socket = new DatagramSocket();
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
        bfr = new BufferedReader(new InputStreamReader(System.in));

    }

    @Override
    public void run() {
        while (true){//循环发送数据
            try {
                String msg = bfr.readLine();
                byte[] buffer = msg.getBytes();
                InetAddress inet = InetAddress.getByName(toIp);
                DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length,inet,toPort);
                socket.send(packet);
                if (msg.equals("886")){//退出条件
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        //释放资源
        if (socket != null){
            socket.close();
        }
        if (bfr != null){
            try {
                bfr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }




    }
}
