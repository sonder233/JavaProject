package ch5.demo2;

import java.io.IOException;

public class Student {
    private String name;
    private int age;
    public String gender;

    public Student() {
    }
    public Student(String name){
        this.name = name;
    }

    protected Student(int age){
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public void sleep(){
        System.out.println("睡觉");
    }

    public String eat(String sth) throws IndexOutOfBoundsException, IOException {
        System.out.println("在吃"+sth);
        return "吃饱了！";
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }
}
