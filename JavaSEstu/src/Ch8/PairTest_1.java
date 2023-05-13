package Ch8;

public class PairTest_1 {
    public static void main(String[] args) {
        String[] words = {"Mary","had","a","little","lamb"};
        myPair<String> mm = ArrayAlg.minmax(words);
        System.out.println(mm.getFirst());
        System.out.println(mm.getSecond());

    }
}
class ArrayAlg{
    public static myPair<String> minmax(String[] a){
        if (a == null || a.length == 0 ) return null;
        String min = a[0];
        String max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i])>0) min = a[i];
            if (max.compareTo(a[i])<0) max = a[i];
        }
        return new myPair<>(min,max);
    }
    public static <T extends Comparable> myPair<T> minmax_2(T[] a){
        if (a == null || a.length == 0 ) return null;
        T min = a[0];
        T max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i])>0) min = a[i];
            if (max.compareTo(a[i])<0) max = a[i];
        }
        return new myPair<>(min,max);
    }
    public static <T> T getMiddle(T...a){
        return a[a.length/2];
    }
}
