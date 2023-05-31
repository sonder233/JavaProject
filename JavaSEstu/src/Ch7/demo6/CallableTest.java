package Ch7.demo6;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> task = new MyCallableTest(0);
        var futureTask = new FutureTask<Integer>(task);
        var thread = new Thread(futureTask);
        thread.start();
        Integer result = futureTask.get();
        System.out.println(result);
    }
}
