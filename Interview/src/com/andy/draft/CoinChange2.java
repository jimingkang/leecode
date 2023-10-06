package com.andy.draft;

public class CoinChange2 {

    public static  void  main(String[]ss)
    {
        int[] a= new int[]{1,3,5};
        int sum = 5;
        int cent = 0;
        int[] dp=new int[sum+1];
        dp[0] = 0;
        for(int i = 1; i <= sum; i++) dp[i] = i;//我们假设存在1元的硬币那么i元最多只需要i枚1元硬币，当然最好设置dp[i]等于无穷大

        for(int i = 1; i <= sum; i++){
            for(int j = 0; j < 3; j++){
                if(i >= a[j]){
                    dp[i] =Math.min(dp[i], dp[i- a[j] ] + 1);
                }
            }
        }
        System.out.println(dp[sum]);

        return ;
    }

}
