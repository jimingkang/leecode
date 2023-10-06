package com.andy.draft;

public class MaxStockProfit {
    public static void main(String []ss){

    }
    public  static int maxProfit(int[] prices) {
        int[][] localmax=new int[prices.length][2];
        int[][] globalmax=new int[prices.length][2];
        for (int i = 1; i <prices.length; i++) {
            for (int j = 0;j <2; j++) {
                int tmp=prices[i]-prices[i-1];
                localmax[i][j] = Math.max(localmax[i-1][j]+tmp,globalmax[i-1][j-1]+tmp);
                globalmax[i][j] = Math.max(localmax[i][j],globalmax[i][j]);
            }
        }

        return 0;
    }
}
