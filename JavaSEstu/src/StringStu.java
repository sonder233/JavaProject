public class StringStu {
    public static void main(String[] args) {
//        String hello = "hello world!";
//        int[] codePoints = hello.codePoints().toArray();
//        for (int i = 0; i < codePoints.length; i++) {
//            print(codePoints[i]);
//        }
        String str1 = "hello ";
        String str2 = "hello jorld";
        print(str1.compareTo(str2));

        StringBuilder builder = new StringBuilder();
        builder.append("http");
        builder.append("://");
        print(builder.toString());
    }

    public static void print(Object obj){
        System.out.println(obj);
    }

}
