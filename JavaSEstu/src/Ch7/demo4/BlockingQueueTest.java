package Ch7.demo4;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueTest {
    public static void main(String[] args) {
        int BOUND = 10;
        int N_PRODUCERS = 16;
        int N_CONSUMERS = Runtime.getRuntime().availableProcessors();
        int poisonPill = Integer.MAX_VALUE;
        int poisonPillProducer = N_CONSUMERS / N_PRODUCERS;
        int mod = N_CONSUMERS % N_PRODUCERS;
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(BOUND);
        //潘金莲熬药
        for (int i = 1; i < N_PRODUCERS; i++) {
            new Thread(new NumbersProducer(queue,poisonPill,poisonPillProducer)).start();
        }
        //武大郎喝药
        for (int i = 1; i < N_CONSUMERS; i++) {
            new Thread(new NumberConsumer(queue,poisonPill,poisonPillProducer)).start();
        }
        //潘金莲开始投毒，武大郎喝完毒药就死
        new Thread(new NumbersProducer(queue,poisonPill,poisonPillProducer+mod)).start();

    }


}
