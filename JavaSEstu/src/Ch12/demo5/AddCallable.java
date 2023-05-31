package Ch12.demo5;

import java.util.concurrent.Callable;

public class AddCallable implements Callable<String> {
    private String start;
    public AddCallable(String start){
        super();
        this.start = start;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        for (int i = 0; i < 1; i++) {
            start += start;
        }
        System.out.println(Thread.currentThread().getName()+": "+ start);
        return start;
    }
}
