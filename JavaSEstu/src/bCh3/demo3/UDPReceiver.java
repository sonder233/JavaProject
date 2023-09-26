package bCh3.demo3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiver implements Runnable{

    DatagramSocket socket = null;
    //接收方自己所在端口
    private int fromPort;
    private String msgFrom;

    public UDPReceiver(int fromPort, String msgFrom) {
        this.fromPort = fromPort;
        this.msgFrom = msgFrom;
        try {
            socket = new DatagramSocket(fromPort);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        //循环接收
        while (true){
            try{
                byte[] buffer = new byte[1024 * 8];//缓冲区
                //构造一个DatagramPacket用于接收指定长度的数据报包到缓冲区中
                DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
                //接收packet
                socket.receive(packet);
                //从packet中提取字符串
                String msg = new String(packet.getData(), 0 , packet.getLength());
                System.out.println(msgFrom+":"+msg);
                if (msg.equals("886")){
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        socket.close();
    }
}
