package Ch12.demo2;

public class ThreadTest2 {
    public static void main(String[] args) {
        MyRun myRun= new MyRun();
        Thread t1 = new Thread(myRun);
        Thread t2 = new Thread(myRun);
        t1.start();
        t2.start();
    }
}
