package com.andy.draft;

import java.util.PriorityQueue;

public class KthLargestNumberInArray {
    public static void main(String[]ss) {
        int[] arr={2,5,1,2,4,9};
        int ret=findKthLargest(arr,3);
        System.out.println(ret);
       /* int [] ret=findSumK(arr,9);
        for (int i=0;i<ret.length;i++
        ) {
            System.out.println(ret[i]);
        }*/
    }
    //有多少情况连续子序列和为K，连续子序列长短不定
    public static int findKthLargest(int[] arr ,int K){
        PriorityQueue<Integer> p=new PriorityQueue<Integer>(){};
      //  p.offer(arr[0]);

        for (int i=0;i<arr.length;i++
             ) {
            if(p.size()<K||p.peek()<=arr[i]){
                p.offer(arr[i]);
            }
            if(p.size()>K) {
                p.poll();
            }

        }
        return p.peek();
    }
}
