package Ch7.demo4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class NumbersProducer implements Runnable {
    private final int poisonPill;
    private final int poisonPillProducer;
    private BlockingQueue<Integer> numberQueue;

    public NumbersProducer(BlockingQueue<Integer> numberQueue,int poisonPill, int poisonPillProducer) {
        this.poisonPill = poisonPill;
        this.poisonPillProducer = poisonPillProducer;
        this.numberQueue = numberQueue;
    }

    @Override
    public void run() {
        
    }
    private void generateNumbers() throws InterruptedException{
        for (int i = 0; i < 100; i++) {
            numberQueue.put(ThreadLocalRandom.current().nextInt(100));
            System.out.println("潘金莲-"+Thread.currentThread().getId()+"号，给武大郎泡的药");
        }
        for (int i = 0; i < poisonPillProducer; i++) {
            numberQueue.put(poisonPill);
            System.out.println("潘金莲-"+Thread.currentThread().getId()+"号，" +
                    "往武大郎药里放的第"+(i+1)+"颗毒药");
        }
    }
}
