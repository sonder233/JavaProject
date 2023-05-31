package Ch9.demo3;

import java.util.*;

public class ViewTest {
    public static void main(String[] args) {
        Map<String,Integer> user = Map.of("Peter",50,"Lucy",8);
        System.out.println(user);
        List<String> list = List.of("Perter","Lucy","Carl");
//        list.set(0,"s");
        List<String> list1 = new ArrayList<>();
        list1.add("Peter");
        list1.add("Tony");
        list1.set(0,"s");
        var v = Collections.unmodifiableList(list1);
        list1.set(0,"CC");
        System.out.println(v);

        
        System.out.println(list1);
        List<String> settings = Collections.nCopies(100,"DEFAULT");
        System.out.println(settings);
    }
}
