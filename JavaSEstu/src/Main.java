public class Main {
    public static void main(String[] args) {
        String str = "hello";
        print(str.length());
        print(str.codePointCount(0,str.length()));
        //从一个字符串的某个位置为起始，返回往后推cpCount个字符位置的字符的索引
        int index = str.offsetByCodePoints(0,2);
        //输出码点
        int cp = str.codePointAt(index);
        print(index);
        print(cp);

        //遍历字符串 查看每一个码点
        //正向遍历
//        int cp_1 = str.codePointAt()
        for (int i = 0; i < str.codePointCount(0,str.length());) {
            int cp_1 = str.codePointAt(i);
            i = i + Character.charCount(cp); //charCount输入的是码点，返回的是代码单元数量（char数量？）、
        }
        print(Character.charCount(cp));
    }

    public static void print(Object obj){
        System.out.println(obj);
    }
}