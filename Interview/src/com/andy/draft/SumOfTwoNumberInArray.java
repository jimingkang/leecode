package com.andy.draft;

import java.util.HashMap;

public class  SumOfTwoNumberInArray {
    public static void main(String[]ss) {
        int[] arr={2,5,7,9};
        int [] ret=findSumK(arr,9);
        for (int i=0;i<ret.length;i++
        ) {
            System.out.println(ret[i]);
        }
    }
    public static int[] findSumK(int[] arr ,int K){
        HashMap m=new HashMap();
        for (int i=0;i<arr.length;i++
             ) {
            if(!m.containsKey(K-arr[i])){
                m.put(arr[i],i);
            }else{
                return new int[]{i, (int) m.get(K-arr[i])};
            }

        }
        return new int[2];
    }
}
