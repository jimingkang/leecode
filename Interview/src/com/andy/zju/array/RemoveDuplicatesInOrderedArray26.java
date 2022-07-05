package com.andy.zju.array;

import java.util.LinkedHashMap;

public class RemoveDuplicatesInOrderedArray26 {
    public static void main(String[] args) {
        removeDuplicates2(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
    public static int removeDuplicates(int[] nums) {
        LinkedHashMap<Integer,Integer> map=new LinkedHashMap();
        for (int i = 0; i < nums.length; i++) {
            if(!map.containsValue(nums[i]))
            {
                map.put(map.size(),nums[i]);

            }

        }
        for (int i = 0; i <map.size(); i++) {
        nums[i]=map.get(i);
        }

        return map.size();

    }
    public static int removeDuplicates2(int[] nums) {
        int j=0;
        //int k=0;
        int cnt=0;
        for (int i =0; i < nums.length-1; i++) {
            if(nums[i]==nums[i+1])
            {


                //tmp=nums[i+1];
                j++;
                cnt++;
            }
            if(nums[i]!=nums[i+1]){

                for (int k = 0; k < j; k++) {
                    nums[i-k]=nums[i+1];
                }

            }

        }

        return nums.length-cnt;

    }
}
