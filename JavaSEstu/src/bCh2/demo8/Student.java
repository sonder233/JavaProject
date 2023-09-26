package bCh2.demo8;

import java.io.Serializable;

/*
Serializable 没有抽象方法，是个标记接口
实现这个接口，说明这个对象可以被序列化
 */
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    //transient 瞬态关键字
    //表示这个变量不会序列化
//    private transient String address;
    private String address;

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name: "+name+", age: "+age +", address: "+address;
    }
}
