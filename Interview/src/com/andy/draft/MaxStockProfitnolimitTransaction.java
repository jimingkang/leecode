package com.andy.draft;

import static java.lang.Math.max;

public class MaxStockProfitnolimitTransaction {
    public static void main(String []ss){
int [] prices=new int[]{3,5,0,3,1,4};//{2,5,7,1,4,3,1,3};
        //        int [] prices={1,2,5,2,7,9};
System.out.println(maxProfit(prices,2));
        int k = 2;
        int[][][] dp = new int[prices.length][k+1 ][2];
        System.out.println(maxProfitStateMachine(prices,2,dp));
    }
    //method 1 ,as long as prices[i]>prices[i-1] then make deal
    public  static int maxProfit(int[] prices) {
        int ret=0;

        for (int i = 1; i <prices.length; i++) {
            if((prices[i]-prices[i-1])>0)
             ret=ret+prices[i]-prices[i-1];



        }


        return ret;
    }

    public  static int maxProfit(int[] prices,int K) {
        int ret=0;

        //method 2 dynamic programming
        int[][] tran=new int[K+1][prices.length];
        for (int i = 1; i <tran.length; i++)
            for (int j = 1; j<prices.length; j++) {
                int lastMax=0;
                for (int m = 0; m<j; m++) {
                    lastMax = max(lastMax,prices[j] - prices[m]+tran[i - 1][m]);
                }
                tran[i][j]= max(tran[i][j-1],lastMax);

        }

        return tran[K][prices.length-1];
    }

    //method 3 dynamic programming state machine
//https://github.com/labuladong/fucking-algorithm/blob/master/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E5%9B%A2%E7%81%AD%E8%82%A1%E7%A5%A8%E9%97%AE%E9%A2%98.md
    public  static int maxProfitStateMachine(int[] prices,int K,int[][][] dp) {
        int ret=0;

        for (int i = 0; i <prices.length; i++)
            for (int j =K; j>=0; j--) {
                if (i - 1 == -1) {
                    // ¥¶¿Ì base case
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0]=max(dp[i-1][1][0], dp[i-1][K-1][1] + prices[i]);
                dp[i][j][1] = max(dp[i-1][1][1], dp[i-1][K][0] - prices[i]);

            }



        return dp[prices.length-1][K][0];
         /*
         //for k=1 one transaction
                int n = prices.length;
                int[][] dp = new int[n][2];
                for (int i = 0; i < n; i++) {
                    dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
                    dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
                }
                return dp[n - 1][0];*/
    }
}
