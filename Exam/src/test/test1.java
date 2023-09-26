package test;

public class test1 {
    public static void main(String[] args) {
        int n = 5;
        if (n < 1 || n > Integer.MAX_VALUE) return;
        if (n == 1) {
            System.out.println(1);
            return;
        }
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n-1]);
    }
}
