package ch5.demo1;

public class ReflectTest1 {
    public static void main(String[] args) throws ClassNotFoundException {
        /**
         * 获取Class对象的三种方式：
         * 1.Class.forName("全类名")  //包加类名
         *      最常用的
         * 2.类名.class
         *      一般当做参数传递
         * 3.对象.getClass()
         *      当我们有了这个类的对象的时候才会调用
         */

        Class clazz_1 = Class.forName("ch5.demo1.Student");
        System.out.println(clazz_1);
        //2.类名.class
        Class clazz_2 = Student.class;
        //3.对象.getClass()
        Student student = new Student();
        System.out.println(student.getClass());

    }
}
