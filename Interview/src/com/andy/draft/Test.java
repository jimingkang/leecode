package com.andy.draft;

import java.util.ArrayList;
import java.util.Collection;

import static com.andy.draft.MaxStockProfitnolimitTransaction.maxProfitStateMachine;

public class Test {
    public static void main(String[]ss){

        int [] arr={1,2,5,2,7,9};
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> current=new ArrayList<Integer>();
        subset(res,0,current,arr);
        System.out.println(res);


 //int [] arr={1,2,5,2,7,9};
 //       int k = 2;
  //      int[][][] dp = new int[arr.length][k + 1][2];
      //  System.out.println(MaxStockProfitnolimitTransaction.maxProfit(arr,2));
 //System.out.println(MaxStockProfitnolimitTransaction.maxProfitStateMachine(arr,2, dp));
    }
    public static int profit(int[]arr){
        int ret=0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>arr[i-1])
                ret +=arr[i]-arr[i-1];

        }
        return ret;
    }

    public static void subset(ArrayList<ArrayList<Integer>> res,int index,ArrayList<Integer> current,int[] ast){
        if(index==current.size())
        {

            ArrayList<Integer>  tmp=new ArrayList<Integer>(current);
            res.add(tmp);
            return;
        }

        for (int i = index; i <ast.length ; i++) {
            current.add(ast[index]);
            subset(res,ast.length,current,ast);
            current.remove(ast[ast.length-1]);

        }

    }
}
