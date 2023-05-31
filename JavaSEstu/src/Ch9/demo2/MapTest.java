package Ch9.demo2;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class MapTest {
    public static void main(String[] args) {
        HashMap<Integer,String> staff = new HashMap<>();
        staff.put(5,"Peter");
        staff.put(9,"Atom");
        staff.put(1,"Carl");
        staff.forEach((id,name) ->{
            System.out.println(""+id+name);
        });
        HashMap<String,Integer> words = new HashMap<>();
        words.put("apple",5);
        words.put("banana",7);
        words.merge("banana",5,(oldValue,newValue)->{
//            System.out.println(oldValue);
//            System.out.println(newValue);
            return oldValue + newValue;
        });

        words.forEach((name,prince)->{
            System.out.println("name:"+name+",prince:"+prince);
        });
        Set<String> keys = words.keySet();
        keys.forEach(element->{
            System.out.println(element);
        });
       var stringIntegerEntry = words.entrySet();
        System.out.println(stringIntegerEntry.getClass().getSimpleName());
    }

}
