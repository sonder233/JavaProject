package Ch9.demo2;

import java.util.HashSet;
import java.util.TreeSet;

public class HashTableTest {
    public static void main(String[] args) {
        System.out.println("Lee".hashCode());
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("Bob");
        treeSet.add("Amy");
        treeSet.add("Carl");
        System.out.println(treeSet.toString());

    }
}
