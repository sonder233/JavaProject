package ch5.demo2;

import java.io.File;
import java.lang.reflect.Field;

public class ReflectTest3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class clazz = Class.forName("ch5.demo2.Student");
        Field[] fields = clazz.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        Field field_1 = clazz.getField("gender");
        System.out.println(field_1);
        Field field_2 = clazz.getDeclaredField("name");
        System.out.println(field_2);

        int modifiers = field_2.getModifiers();
        System.out.println(modifiers);

        //获取成员变量的名字
        String n = field_2.getName();
        System.out.println(n);
        //获取成员变量记录的值
        Student student = new Student("lisa");
        field_2.setAccessible(true);
        String str = (String) field_2.get(student);
        System.out.println(str);

        //修改对象里面记录的值
        field_2.set(student,"王大锤");
        System.out.println(student);
    }
}
