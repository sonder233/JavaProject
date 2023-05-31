package Ch12.demo2;

public class MyRun implements Runnable{
    @Override
    public void run() {
        Thread curThread = Thread.currentThread();
        for (int i = 0; i < 100; i++) {
            System.out.println(curThread.getName()+": Hello");
        }
    }
}
