package ch5.demo2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

public class ReflectTest2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class clazz = Class.forName("ch5.demo2.Student");
        Constructor[] cons = clazz.getConstructors();
        for(var con : cons){
            System.out.println(con);
        }
        System.out.println("------------------------------------------------------------");
        Constructor[] cons_all = clazz.getDeclaredConstructors();
        for(var con : cons_all){
            System.out.println(con);
        }
        System.out.println("------------------------------------------------------------");
        Constructor con_1 = clazz.getConstructor();
        System.out.println(con_1);

        Constructor con_2 = clazz.getConstructor(String.class);
        System.out.println(con_2);

        Constructor con_3 = clazz.getDeclaredConstructor(int.class);
        System.out.println(con_3);

        Constructor con_4 = clazz.getDeclaredConstructor(String.class,int.class);
        System.out.println(con_4);
        System.out.println("------------------------------------------------------------");
        int modifiers = con_4.getModifiers();
        System.out.println(modifiers);
        Parameter[] parameters = con_4.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }
        //利用反射创建对象，这里的构造函数是公有的
        Student student_1 = (Student) con_2.newInstance("name");
        //暴力反射：临时取消校验权限（也就是令private无效）
        con_4.setAccessible(true);
        Student student_2 = (Student) con_4.newInstance("Lisa", 20);
        System.out.println(student_2.toString());
    }
}
