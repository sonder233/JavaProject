import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.pow;

public class Main_now {
    public static void main(String[] args) {


    }

    

    public static void HJ8(){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int count = in.nextInt();
            int[][] numbers = new int[count][2];
            //初始化
            for (int i = 0; i < count; i++) {
                numbers[i][0] = in.nextInt();
                numbers[i][1] = in.nextInt();
            }
            for (int i = 0; i < count; i++) {
                if (i>0){
                    int index = numbers[i][0];//索引值
                    for (int j = 0; j < count; j++) {//重新遍历
                        if(j != i && index == numbers[j][0]){
                            numbers[i][1] += numbers[j][1];
                            numbers[j][0] = -1;
                        }
                    }
                }
            }
            for (int i = 0; i < count; i++) {
                if ( numbers[i][0] > 0 ){
                    System.out.println(numbers[i][0]+" "+numbers[i][1]);
                }
            }
        }
    }

    //得到质数高效方法
    public static void getZhi_2(int number){
        int temp = number;
        for(int i =2; i*i<=temp && i<=number;i++){
            while (number%i == 0){
                System.out.print(i+" ");
                number /= i;
            }
        }
        if (number - 1 != 0){
            System.out.print(number);
        }
    }

    public static void getZhi(int number ){
        for (int i = 2; i <= number; i++) {
            if (number %i == 0){//是因子
                System.out.print(i + " ");
                if (number / i != 1) {
                    getZhi(number / i);
                    break;
                }
            }
        }
    }


    public static void HJ6(){
        //十六进制转十进制
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a =String.valueOf(in.next()).replace("0x","") ;
            System.out.println(Integer.parseInt(a,16));
        }
    }

    public static void HJ1(){

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String str = in.next();
            int lastIndex = str.lastIndexOf(" ");
            System.out.println(lastIndex);
            System.out.println(str.length()-lastIndex);
        }
    }
    public static void HJ101(){

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int count = in.nextInt();

            int[] arr = new int[count];

            for (int i = 0;i<count;i++){
                arr[i] = in.nextInt();
            }
            int type = in.nextInt();
            Arrays.sort(arr);
            if (type == 0){
                for (int i = 0; i < count; i++) {
                    System.out.print(arr[i] + " ");
                }
            }else {
                for (int i = 0; i < arr.length-1; i++) {
                    for (int j = arr.length-1;j >i; j--) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
                for (int i = 0; i < count; i++) {
                    System.out.print(arr[i] + " ");
                }
            }
        }
    }


    public static void HJ58(){

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int count = in.nextInt();
            int number = in.nextInt();

            int[] arr = new int[count];
            for (int i = 0;i<count;i++){
                arr[i] = in.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < number; i++) {
                System.out.print(arr[i]+" ");
            }
        }

    }
    public static void HJ46(){
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.next();
            int number = in.nextInt();
            String result = a.substring(0,number);
            System.out.println(result);
        }
    }
    public static void HJ9(){
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        int n = (int) Math.log10(number)+1; //number位数
        boolean[] numbers = new boolean[10];//默认值全是false
        int count = 0;
        int result = 0;

        for (int i = 1; i <= n; i++) {
            int a = (int) ((number % pow(10,i))/pow(10,i-1));
            if(!numbers[a]){
                result += (int) (a * pow(10,count));
                count++;
                numbers[a] = true;
            }
        }
        StringBuilder str_result = new StringBuilder(String.valueOf(result));
        String temp = str_result.reverse().toString();
        result = Integer.parseInt(temp);
        System.out.println(Integer.parseInt(temp));
    }
}
