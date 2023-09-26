package bCh4;

public class TestProxy {
    public static void main(String[] args) {
        BigStar bigStar = new BigStar("cxk");
        Star proxy = ProxyUtil.createProxy(bigStar);

        String res = proxy.sing("及你太美");
        System.out.println(res);
    }
}
