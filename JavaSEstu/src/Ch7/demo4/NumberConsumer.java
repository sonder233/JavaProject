package Ch7.demo4;

import java.util.concurrent.BlockingQueue;

public class NumberConsumer implements Runnable{
    private final int poisonPill;
    private final int poisonPillProducer;
    private BlockingQueue<Integer> queue;

    public NumberConsumer( BlockingQueue<Integer> numberQueue,int poisonPill, int poisonPillProducer) {
        this.poisonPill = poisonPill;
        this.poisonPillProducer = poisonPillProducer;
        this.queue = numberQueue;
    }

    @Override
    public void run() {
        try {
            while (true){
                Integer number = queue.take();
                if (number.equals(poisonPill)){
                    return;
                }
                System.out.println("武大郎-"+Thread.currentThread().getId()+
                        "号，喝药-编号"+number);
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
