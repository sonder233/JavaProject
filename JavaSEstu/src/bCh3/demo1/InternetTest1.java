package bCh3.demo1;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class InternetTest1 {
    public static void main(String[] args) throws UnknownHostException {
        //InetAddress表示IP地址

        //获取本机ip
        InetAddress ip = InetAddress.getLocalHost();
        System.out.println(ip);//DESKTOP-QKGMOEO/192.168.56.1
        System.out.println(ip.getHostName());//主机名
        System.out.println(ip.getHostAddress());//ip地址
        //getLocalHost=getHostName+getHostAddress
        System.out.println(InetAddress.getAllByName("localhost"));

        //获取百度的
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println(baidu.getHostName());
        System.out.println(baidu.getHostAddress());

        //inetSocketAddress
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",8082);
        System.out.println(inetSocketAddress);//  /127.0.0.1:8082
        System.out.println(inetSocketAddress.getHostName());
        System.out.println(inetSocketAddress.getPort());
        InetAddress address = inetSocketAddress.getAddress();
        System.out.println(address);
    }
}
