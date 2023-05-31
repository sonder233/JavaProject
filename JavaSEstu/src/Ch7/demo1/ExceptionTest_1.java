package Ch7.demo1;

import java.io.IOException;

public class ExceptionTest_1 {
    public static void main(String[] args) {

        try {
            readData();
        }catch (MyFormatException exception){
            exception.printStackTrace();
        }
        System.out.println("world ends");
    }
    public static String readData() throws MyFormatException{
        int[] nums = new int[5];
        try {
            nums[-1]=0;
        }catch (RuntimeException exception){
            exception.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            assert i > 5;
            System.out.println(i);
            if (i > 5){
                var exception = new MyFormatException("help");
                System.out.println(exception.getMessage());
                throw exception;
            }
        }
        return "test";
    }
}
