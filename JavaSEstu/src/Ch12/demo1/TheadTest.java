package Ch12.demo1;

public class TheadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.setName("thread 1");
        t2.setName("thread 2");
        t1.start();
        t2.start();
    }
}
