package Ch9.demo2;

import java.util.*;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        Queue<String> queue1 = new LinkedList<>();
        Deque<String> deque = new ArrayDeque<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(6);
        priorityQueue.add(9);
        priorityQueue.add(1);
        priorityQueue.add(12);
        priorityQueue.forEach(element->{
            System.out.println(element);
        });
    }
}
