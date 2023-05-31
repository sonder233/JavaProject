package Ch7.demo6;

import java.util.concurrent.Callable;

public class MyCallableTest implements Callable<Integer> {
    public int begin = 0;

    public MyCallableTest(int begin) {
        this.begin = begin;
    }

    @Override
    public Integer call() {
        try {
            Thread.sleep(2000);//模拟耗时任务
            for (int i = 0; i < 1000; i++) {
                begin += i;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            return begin;
        }
    }
}
