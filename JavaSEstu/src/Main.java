import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.*;
import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        Size size = Enum.valueOf(Size.class,"SMALL");
        print(size.getAbbreviation());

        print(size);
        Size[] values = Size.values();
        for (var s :
                values) {
            print(s);
        }
        Employee[] staff = new Employee[3];
        Manager m = new Manager("Tony",5000.0);
        Employee employee =  new Employee("opp",50);
        print(m.hashCode());
        print(m instanceof Employee);
        Object o = new Manager();
        Employee e = (Employee)o;
        staff[0] = m;
        staff[1] = new Employee("Carl",6000);
        staff[2] = new Employee("Harry",3500);
        print(staff[0].getName());
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(3);
        list.add(1);
        list.add(6);
        list.set(1,9);
        list.remove(1);
        print(list.get(1));
        var it = list.iterator();
        while (it.hasNext()){
            if (it.next()%2 == 0){
                it.remove();
            }
        }
        print(list);
        LinkedList<String> sites = new LinkedList<String>();
        sites.add("hello");
        sites.add("world");
        sites.add("daddy");
        sites.set(1,"mom");
        sites.add(1,"father");
        print(sites);
        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
        hashMap.put("Tony",50);
        hashMap.put("Lisa",88);
        hashMap.put("Carl",69);
        hashMap.put("Carl",77);//会存入77
        print(hashMap);
//        hashMap.remove("Lisa");
        print(hashMap.get("Carl"));
        for (String i : hashMap.keySet()) {
            print("key:" + i +",value:" + hashMap.get(i) );
        }
        for (Integer i :
                hashMap.values()) {
            print(i+",");
        }

    }

    public static void print(Object obj){
        System.out.println(obj);
    }
}
class LengthComparator implements Comparator<String>{
    public int compare(String first,String second){
        return first.length()-second.length();
    }
}
record Positon(double x, double y){
    private static double r;
    public static double distance(Positon p,Positon q){
        return Math.hypot(p.x() - q.x(), p.y()-q.y());
    }
}