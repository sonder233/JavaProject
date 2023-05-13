package myInterface;

public interface Animal {
    int age();
    default boolean is18(){return age()>18;}
}
