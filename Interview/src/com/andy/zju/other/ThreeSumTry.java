package com.andy.zju.other;

import java.util.ArrayList;
import java.util.HashMap;

/*
https://leetcode.com/problems/two-sum/description/
Given nums = [2, 7, 11, 15], target = 9,
        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].*/
public class ThreeSumTry {
    public static ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
    static HashMap<Integer,Integer> hashMap=new HashMap<>();
public static ArrayList<Integer> twosum(int[] nums,int start,int end, int target){
  hashMap.clear();
    for (int i =start; i <end ; i++) {
        if(hashMap.containsKey(target-nums[i]))
        {
            ArrayList<Integer> ans=new ArrayList<>();
            ans.add(target);
            ans.add(nums[i]);
            ans.add(target-nums[i]);
            res.add(ans);
            return ans;
        }
        hashMap.put(nums[i],i);

    }
    return null;

}
        public static  ArrayList<ArrayList<Integer>> threesum(int[] nums,int tarindex, int target) {
            ArrayList<Integer> tmplist=null;
            for (int i=0;i<nums.length;i++) {
                ArrayList<Integer> tmp=  twosum(nums,i+1,nums.length,target-nums[i]);
                if(tmp!=null)
                    res.add(tmp);
            }

            return res;
        }


    public static void quickSort(int[]a,int begin,int end) {
        if (begin < end) {
            int p = patition(a, begin, end);
            quickSort(a, begin, p - 1);
            quickSort(a, p + 1, end);
        }
    }
    public static int patition(int[] a,int begin,int end){

        int res=-1;
        int i=begin-1;
        int pivot=a[end];
        for (int k = begin; k < end-1; k++) {
            if(a[k]<=pivot){
                i++;
                swap(a,i,k);
            }
        }
        swap(a,i+1 ,end);
        return i+1;

    }
    public static void swap(int [] a, int i,int j){
    int tmp=0;
    tmp=a[i];
    a[i]=a[j];
    a[j]=tmp;
    }
        public static void main(String[]ss){
           int[] nums =new int[] {-1,0,1,2,-4};
            ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
            ThreeSumTry threeSum=new ThreeSumTry();
            quickSort(nums,0,nums.length-1);
            for (int i = 0; i <nums.length ; i++) {
                ArrayList<ArrayList<Integer>> res= threeSum.threesum(nums,i,0);
            }

            System.out.println(res);
            }


}
