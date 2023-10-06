package com.andy.draft;

public class CoinChange {
    public static void main(String[] ss){
        int amount =5;
        int[] coins=new int[]{1,2,3};
        System.out.println(change(5,coins));
    }
    public static int change(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return amount == 0? 1: 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i ++) {
            for (int j = 1; j <= amount; j ++) {
                if (j >= coins[i]) {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }
}
