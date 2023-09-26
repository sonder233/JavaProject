package test;

import java.util.Arrays;
import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        //1 2 3 1
        //4
        //2 7 9 3 1
        //12
//        int[] nums = {2,7,9,3,1};
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        if (nums.length == 1){
            System.out.println(nums[0]);
            return;
        }
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < n ; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i]);
        }
        System.out.println(dp[n-1]);

    }
}
