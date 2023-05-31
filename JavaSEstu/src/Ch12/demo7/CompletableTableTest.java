package Ch12.demo7;

import java.util.concurrent.*;

public class CompletableTableTest {
    public static ExecutorService executorService = Executors.newCachedThreadPool();
    public static void main(String[] args) {
        test_4();
    }

    public static void test_4(){
        CompletableFuture<String> firstFuture = CompletableFuture.supplyAsync(()->{
            System.out.println("先执行第一个CompletableFuture方法任务");
            System.out.println("当前线程名称："+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return "第一个任务的返回值";
        },executorService);
        CompletableFuture secondFuture = firstFuture.whenComplete((returnValue,throwable)->{
            System.out.println("当前线程名称："+Thread.currentThread().getName());
            System.out.println("我是第二个任务，我得到了返回值-->"+returnValue
                            + "，还有throwable-->"+throwable
                    );
            if ("第一个任务的返回值".equals(returnValue)){
                System.out.println("确定收到了第一个的结果啦");
            }
        });
        try {
            System.out.println(secondFuture.get(2, TimeUnit.SECONDS));
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }


    public static void test_3(){
        CompletableFuture<String> firstFuture = CompletableFuture.supplyAsync(()->{
            System.out.println("当前线程名称："+Thread.currentThread().getName());
            System.out.println("先执行第一个CompletableFuture方法任务");
            return "第一个任务的返回值";
        },executorService);
        CompletableFuture secondFuture = firstFuture.thenAccept((returnValue)->{
            System.out.println("当前线程名称："+Thread.currentThread().getName());
            System.out.println("我是第二个任务，我得到了-->"+returnValue);
        });
        executorService.shutdown();
    }
    public static void test_2(){
        CompletableFuture<String> firstFuture = CompletableFuture.supplyAsync(()->{
                    System.out.println("当前线程名称："+Thread.currentThread().getName());
                    System.out.println("先执行第一个CompletableFuture方法任务");
                    return "第一个任务的返回值";
                    },executorService);
        CompletableFuture secondFuture = firstFuture.thenRun(()->{
            System.out.println("当前线程名称："+Thread.currentThread().getName());
            System.out.println("第二个方法任务");
        });
        executorService.shutdown();
    }
    public static void test_1(){

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()->{
            String tmp = "hello ";
            System.out.println(Thread.currentThread().getName());
            return tmp;
        },executorService);
        String result = completableFuture.join();
        System.out.println(result);
        executorService.shutdown();
    }
}
