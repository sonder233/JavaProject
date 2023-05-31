package Ch12.demo3;

import java.util.concurrent.FutureTask;

public class ThreadTest3 {
    public static void main(String[] args) throws Exception {
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread t1 = new Thread(futureTask);
        t1.start();
        Integer result = futureTask.get();
        System.out.println(result);
    }
}
