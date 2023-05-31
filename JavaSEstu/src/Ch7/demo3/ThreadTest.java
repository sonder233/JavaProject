package Ch7.demo3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadTest {
    public static final ThreadLocal<SimpleDateFormat> dataFormat =
            ThreadLocal.withInitial(()-> new SimpleDateFormat("yyyy-MM-dd"));

    public static AtomicInteger nextNumber = new AtomicInteger();


    public static void main(String[] args) {
        for(int i = 0;i<100; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int id = nextNumber.incrementAndGet();
                    System.out.println(Thread.currentThread().getName()+": "+id);
                }
            }).start();
        }
//        for (int i = 0; i < 5; i++) {
//            Runnable r = () -> {
//                String dataStamp = dataFormat.get().format(new Date());
//                System.out.println(Thread.currentThread().getName()+": "+dataStamp);
//            };
//            Thread t = new Thread(r);
//            t.start();
//        }
 
    }
}
