package com.andy.leecode.subset;

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {

    public static void main(String[] ss){
        int[] test=new int[]{1,2,3};
        //int [] ast= asterriod_collision(test);
        List<List<Integer>>res=new ArrayList<>();

        res=combine(4,2);
        for (List li:res) {
            for (int i = 0; i <li.size() ; i++) {
                System.out.print(li.get(i)+",");
            }
            System.out.println();

        }


    }
    public static List<List<Integer>> combine(int n, int k) {
        List<Integer> v=new ArrayList<Integer>();
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        combine2(1,n,k,res,v);
        return res;


    }
    public static List<List<Integer>> combine(int start,int n, int k,List<List<Integer>>res,List<Integer> v) {
        if(v.size()==k)
        {
            res.add(new ArrayList<Integer>(v));
            return res;
        }



        for(int i=start;i<n;i++)
        {
            // if(v.size()<k)
            v.add(i);
            combine(i+1,n,k,res,v);
            v.remove(v.size()-1);
        }
        return res;
    }

    public static void combine2(int start,int n, int k,List<List<Integer>>res,List<Integer> v) {
         if(v.size()==k)
         {
            res.add(new ArrayList<Integer>(v));
            return ;
        }
        if (start > n) {
            return;
        }



         v.add(start);
         combine2(start+1,n,k,res,v);

         v.remove(v.size()-1);
        combine2(start+1,n,k,res,v);

    }
}
