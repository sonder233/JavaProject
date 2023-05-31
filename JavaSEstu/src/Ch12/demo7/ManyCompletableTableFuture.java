package Ch12.demo7;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ManyCompletableTableFuture {
    public static ExecutorService executorService = Executors.newFixedThreadPool(1);

    public static void main(String[] args) {
        test_2();
    }
    public static void test_2(){
        CompletableFuture<String> first = CompletableFuture.supplyAsync(
                ()->{
                    try {
                        Thread.sleep(3000);
                        System.out.println("执行完第一个异步任务");
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    return "第一个异步任务";
                });
        CompletableFuture<Void> second = CompletableFuture.supplyAsync(
                ()->{
                    System.out.println("执行完第二个异步任务");
                    return "第二个异步任务";
                },executorService)
                .acceptEitherAsync(first,System.out::println,executorService);
        executorService.shutdown();

    }
    public static void test_1(){
        //Returns a new CompletableFuture that is already completed with the given value.
        //Params: value – the value
        //Returns: the completed CompletableFuture
        CompletableFuture<String> firstFuture =
                CompletableFuture.completedFuture("第一个异步任务");
        CompletableFuture<String> secondFuture = CompletableFuture
                .supplyAsync(()->"第二个异步任务",executorService)
                .thenCombineAsync(firstFuture,(s,w)->{
                    System.out.println(s);
                    System.out.println(w);
                    return "两个异步任务的组合";
                },executorService);
        System.out.println(secondFuture.join());
        executorService.shutdown();
    }

}
