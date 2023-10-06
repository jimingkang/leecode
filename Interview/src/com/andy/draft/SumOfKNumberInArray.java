package com.andy.draft;

import java.util.HashMap;

public class SumOfKNumberInArray {
    public static void main(String[]ss) {
        int[] arr={2,5,1,2,4,9};
        int ret=findSumK(arr,7);
        System.out.println(ret);
       /* int [] ret=findSumK(arr,9);
        for (int i=0;i<ret.length;i++
        ) {
            System.out.println(ret[i]);
        }*/
    }
    //有多少情况连续子序列和为K，连续子序列长短不定
    public static int findSumK(int[] arr ,int K){
        HashMap m=new HashMap();
        m.put(0,1);
        int sum=0;
        int count=0;
        for (int i=0;i<arr.length;i++
             ) {
            sum+=arr[i];
            if(m.containsKey(sum-K)){

                count+=(int)m.get(sum-K);
            }
            m.put(sum,((int)m.getOrDefault(sum,0))+1);
        }
        return count;
    }
}
