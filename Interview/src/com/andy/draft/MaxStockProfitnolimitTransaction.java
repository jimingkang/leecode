package com.andy.draft;

public class MaxStockProfitnolimitTransaction {
    public static void main(String []ss){
int [] prices=new int[]{2,5,7,1,4,3,1,3};
System.out.println(maxProfit(prices));
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
    //method 1 ,as long as prices[i]>prices[i-1] then make deal
    public  static int maxProfit(int[] prices,int K) {
        int ret=0;

        //method 2 dynamic programming
        int[][] tran=new int[K+1][prices.length];
        for (int i = 1; i <tran.length; i++)
            for (int j = 1; j<prices.length; j++) {

            int lastMax=0;
            for (int m = 0; m<j; m++) {
                lastMax = Math.max(lastMax,prices[j] - prices[m]+tran[i - 1][m]);
            }

                tran[i][j]=Math.max(tran[i][j-1],lastMax);

        }

        return tran[K][prices.length-1];
    }
}
