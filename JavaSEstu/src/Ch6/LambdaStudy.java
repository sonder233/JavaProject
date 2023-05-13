package Ch6;

import myInterface.MyCute;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Timer;

public class LambdaStudy {

    

    public static void main(String[] args) {
        int a=5,b=10;

        String res = whoisCutter(new MyCute() {
            @Override
            public String getCutter(int dog, int cat) {
                if (dog > cat){
                    return "dog";
                }else{
                    return "cat";
                }
            }

            @Override
            public String getBigger(int animal) {
                return null;
            }
        });
        System.out.println(res);
    }
    public static void repeatMessage(String text, int delay){
        ActionListener listener = event->{
            System.out.println(text);
            Toolkit.getDefaultToolkit().beep();
        };
    }
    public static String whoisCutter(MyCute cute){
        int dog = 5;
        int cat = 2;
        return cute.getCutter(dog,cat);
    }
}
