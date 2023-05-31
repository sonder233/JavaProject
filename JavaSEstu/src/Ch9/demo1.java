package Ch9;

import java.util.*;

public class demo1 {


    public static void main(String[] args) {
        Queue<Integer> queue_1 = new LinkedList<>();
        Queue<Integer> queue_2 = new ArrayDeque<>();
        List<String> list_1 = new ArrayList<>();
        list_1.add("hello");
        list_1.add("world");
        list_1.add("rabbit");
        Iterator<String> iterator = list_1.iterator();
        iterator.next();
        iterator.remove();
        iterator.forEachRemaining(element-> System.out.println(element));
        LinkedList list_2 = new LinkedList<>();
        list_2.add("Amy");
        list_2.add("Bob");
        list_2.add("Carl");

        ListIterator<String> listIterator = list_2.listIterator();
        listIterator.next();
        listIterator.add("Juliet");
//        listIterator.remove();
        System.out.println(listIterator.next());
        listIterator.remove();
        System.out.println(listIterator.next());
        listIterator.set("David");
        System.out.println(list_2);

    }
}
