package Ch7.demo1;

import java.io.IOException;

public class MyFormatException extends IOException {
    public MyFormatException(){};
    public MyFormatException(String gripe){
        super(gripe);
    }
}
