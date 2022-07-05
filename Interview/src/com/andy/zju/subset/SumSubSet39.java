package com.andy.zju.subset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SumSubSet39 {

    public static void main(String[] ss){
        int[] test=new int[]{2,3,6,7};
       //int [] ast= asterriod_collision(test);
        List<List<Integer>>res=new ArrayList<>();
         int target=7;
        sumsubset(res,test,new ArrayList<>(),0,target);
        for (List li:res) {
            for (int i = 0; i <li.size() ; i++) {
                System.out.print(li.get(i)+",");
            }
            System.out.println();

        }

    }
    public static void sumsubset(List<List<Integer>>res,int[] ast,List<Integer> cur, int index,int target) {
        if(target<0)
            return;
        if(target==0)
        {

            res.add(new ArrayList<Integer>(cur));
           return;
       }
        //else if(target>0) {
        //HashMap<Integer,Integer> hashMap=new HashMap<>();
            for (int i = index; i <ast.length ; i++) {
                cur.add(ast[i]);
                sumsubset(res, ast, cur, i, target - ast[i]);
                cur.remove(cur.size() - 1);

           }

        //}


    }
}
