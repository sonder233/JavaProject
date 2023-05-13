package Ch8.demo1;

public class Test_1 {
    public static void main(String[] args) {
        Box<Number> box_1 = new Box<>();
        box_1.setFirst(100);
        showBox(box_1);
        Box<Integer> box_2 = new Box<>();
        box_2.setFirst(200);
        showBox(box_2);
    }
    public static void showBox(Box<?> box){
        Object first = box.getFirst();
        System.out.println(first);

    }
}
