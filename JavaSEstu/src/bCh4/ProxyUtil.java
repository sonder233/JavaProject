package bCh4;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {

    public static Star createProxy(BigStar bigStar){
        Star star =(Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        /*
                        参数一：代理的对象
                        参数二：要运行的方法sing
                        参数三：调用方法时传递的实参
                         */
                        if ("sing".equals(method.getName())){
                            System.out.println("话筒");
                        }else if ("dance".equals(method.getName())){
                            System.out.println("舞台");
                        }
                        return method.invoke(bigStar,args);
                    }
                });
        return star;
    }

}
