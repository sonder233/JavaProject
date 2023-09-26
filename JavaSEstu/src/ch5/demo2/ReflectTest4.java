package ch5.demo2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ReflectTest4 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class clazz = Class.forName("ch5.demo2.Student");
        //getMethods() 包含父类的所有方法
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("-----------------------------------------------");
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod);
        }
        System.out.println("-----------------------------------------------");
        Method eat = clazz.getDeclaredMethod("eat", String.class);
        System.out.println(eat);
        int modifiers = eat.getModifiers();
        System.out.println(modifiers);
        String name = eat.getName();
        System.out.println(name);
        Parameter[] parameters = eat.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter);
        }
        Class[] exceptionTypes = eat.getExceptionTypes();
        for (Class exceptionType : exceptionTypes) {
            System.out.println(exceptionType);
        }
        Student student = new Student("lisa",23);
        String ret = (String) eat.invoke(student, "三明治");
        System.out.println(ret);
    }
}
