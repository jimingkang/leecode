package com.andy.leecode.dp;

public class MaxStockProfit122 {

    //贪心算法,只能解决一次交易的问题
    public static int maxprofit1(int []a){
        int minprice=a[0];
        int maxprofit=0;
        for (int i = 1; i <a.length ; i++) {
            // if(a[i]>minprice){

            maxprofit=Math.max(maxprofit,a[i]-minprice);
            minprice = Math.min(minprice, a[i]);
            //  }
            //   else{
            //      minprice=a[i];
            //   }
        }
        return maxprofit;
    }
    //一个变量搞定不限次交易的问题,记录上涨获利的交易
    public static int maxprofit2(int []a){
        int price=a[0];
        int maxprofit=0;
        for (int i = 1; i <a.length ; i++) {
            if(a[i]>a[i-1]){
                maxprofit+=(a[i]-a[i-1]);
            }
        }
        return maxprofit;
    }
    //DP搞定有限次交易的问题,记录上涨获利的交易,  //状态是:0表示不持有,1表示持有
    public static int maxprofit3(int []a,int k){
        int price=a[0];
        int maxprofit=0;
        int matrix[][][]=new int[a.length][k+1][2];
        for (int j = 0; j <= k; j++) {
            matrix[0][j][0] = 0;            // 第 0 天不持有，利润为 0
            matrix[0][j][1] = -a[0];        // 第 0 天买入
        }
        // j = 0 时不允许持有
        for (int i = 0; i < a.length; i++) {
            matrix[i][0][1] = Integer.MIN_VALUE / 2;
        }
        for (int i = 1; i <a.length ; i++) {
            for (int j = 1; j <=k ; j++) {
              //  if(a[i]>a[i-1])

                matrix[i][j][0]=Math.max(matrix[i-1][j][0],matrix[i-1][j][1]+a[i]);
                matrix[i][j][1]=Math.max(matrix[i-1][j-1][0]-a[i],matrix[i-1][j][1]);

                //System.out.println("  j=" + j + " notHold=" + matrix[i][j][0] + " hold=" + matrix[i][j][1]);
            }
           // System.out.println("----------------");
        }
        return matrix[a.length-1][k][0];
    }
//DP算法,local / global 是“以卖出为锚点”的模型，不显式区分每天的买入动作。//状态是:第i天是不是卖出
    public static int maxprofit4(int []a,int k){
        int price=a[0];
        int maxprofit=0;
        int local[][]=new int[a.length][k+1];
        int global[][]=new int[a.length][k+1];
        for (int j = 0; j <= k; j++) {
            local[0][j] = 0;            // 第 0 天不持有，利润为 0
            global[0][j] = 0;   // 不交易
        }

        for (int i = 1; i <a.length ; i++) {
            for (int j = 1; j <=k ; j++) {
                int diff=a[i]-a[i-1];

                local[i][j]  = Math.max(global[i-1][j-1] + Math.max(diff, 0), local[i-1][j] + diff
                );
                global[i][j] = Math.max(global[i-1][j], local[i][j]);

            }

        }
        return global[a.length-1][k];
    }


    public static void  main(String[]as){
        int []a={7,1,5,3,6,4};

        System.out.println(maxprofit1(a));
        System.out.println(maxprofit2(a));
        System.out.println(maxprofit3(a,2));
        System.out.println(maxprofit4(a,2));
    }
}
