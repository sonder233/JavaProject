package bCh3.demo3;

public class Teacher {
    public static void main(String[] args) {
        new Thread(new UDPSender("127.0.0.1",7777)).start();
        new Thread(new UDPReceiver(8888,"学生")).start();
    }
}
