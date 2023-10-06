package com.andy.draft;

public class MaxSubIntergerListSum {
    public static void main(String[]ss){
      int[] aa=  new int []{ -2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubIntergerListSum(aa));
    }
    public static int maxSubIntergerListSum(int[]a){
        int max=0;
        int tmp_sum=0;
        for(int i=0;i<a.length;i++){
          if(a[i]>0)tmp_sum+=a[i];
          else
              tmp_sum=a[i];

          max=Math.max(max,tmp_sum);
        }

        return max;
    }
}
