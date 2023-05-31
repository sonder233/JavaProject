package Ch12.demo5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorTest {
    public static void test_1(){
        ExecutorService executorService = Executors.newCachedThreadPool();
//        ThreadPoolExecutor threadPoolExecutor =(ThreadPoolExecutor) Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            AddRunnable addRunnable = new AddRunnable();
            executorService.execute(addRunnable);
        }
        executorService.shutdown();
    }
    public static void test_2() throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> future_1 = executorService.submit(new AddCallable("Adel"));
        Future<String> future_2 = executorService.submit(new AddCallable("Bally"));
        System.out.println(Thread.currentThread().getName()+": "+future_1.get());
        System.out.println(Thread.currentThread().getName()+": "+future_2.get());
    }
    public static void main(String[] args) throws Exception {
//        test_1();
        test_2();
    }
}
