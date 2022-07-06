package com.andy.zju.subset;

import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
 static   List<List<Integer>>res=new ArrayList<>();
    public static void main(String[] args) {

        int[] test={1,2,3};
        permute1(test);
        System.out.println(res);
    }
  //method1
    public static List<List<Integer>> permute1(int[] nums) {


        subset(res,nums,new ArrayList<>());
        return res;
    }
    public  static void subset(List<List<Integer>>res, int[] ast, List<Integer> cur) {
        if(cur.size()==ast.length)
        {
            res.add(new ArrayList<Integer>(cur));

        }
        else {
            for(int i = 0; i < ast.length; i++) {
                if(cur.contains(ast[i])) continue;
                cur.add(ast[i]);
                subset(res, ast, cur);
                cur.remove(cur.remove(cur.size() - 1));
            }
        }


    }


    //method 2
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        //从下标 0 开始的所有组合
        upset(nums, 0, all);
        return all;
    }

    private void upset(int[] nums, int begin, List<List<Integer>> all) {
        if (begin == nums.length) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                temp.add(nums[i]);
            }
            all.add(new ArrayList<Integer>(temp));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            swap(nums, i, begin);
            upset(nums, begin + 1, all);
            swap(nums, i, begin);
        }

    }

    private void swap(int[] nums, int i, int begin) {
        int temp = nums[i];
        nums[i] = nums[begin];
        nums[begin] = temp;
    }
}
