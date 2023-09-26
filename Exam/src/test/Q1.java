package test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        //10,20,5
        //5,5,2
        //15
        Scanner scanner = new Scanner(System.in);
        String lineCake = scanner.nextLine();
        String lineGift = scanner.nextLine();
        if ("".equals(lineCake) || "".equals(lineGift)){
            System.out.println(0);
            return;
        }
        if (lineCake.startsWith("[")){
            lineCake = lineCake.substring(1,lineCake.length()-1);
        }
        if (lineGift.startsWith("[")){
            lineGift = lineGift.substring(1,lineGift.length()-1);
        }
        long[] cakes = Arrays.stream(lineCake.split(","))
                .mapToLong(Long::parseLong)
                .toArray();
        long[] gifts = Arrays.stream(lineGift.split(","))
                .mapToLong(Long::parseLong)
                .toArray();
        long x = Long.parseLong(scanner.nextLine());
        Arrays.sort(cakes);
        Arrays.sort(gifts);
        long count = 0;
        for (int i = 0; i < cakes.length; i++) {
            if (cakes[i] >= x) break;
            for (int j = 0; j < gifts.length; j++) {
                long sum = cakes[i] + gifts[j];
                if (sum <= x){
                    count++;
                }else{
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
