package Ch7.demo5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingTest {
    public static void main(String[] args) {
        DateFormat df = new SimpleDateFormat("HH:mm:ss---");
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);
        Thread consumerThread = new Thread(){
            @Override
            public void run(){
                while (true){
                    try {
                        Integer value = blockingQueue.take();
                        System.out.println(df.format(new Date()) + "get " +
                                value + " from queue");
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };
        consumerThread.start();
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    try {
                        blockingQueue.put(i);
                        System.out.println(df.format(new Date()) + "put " +
                                i + " to queue");
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        });
        producerThread.start();
    }
}
