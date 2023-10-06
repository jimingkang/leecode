package com.andy.draft;

import java.util.*;

public class SubSet {
    public static void main(String[] ss){
        int[] test=new int[]{1,2,3};
       //int [] ast= asterriod_collision(test);
        List<List<Integer>>res=new ArrayList<>();
subset(res,test,new ArrayList<>(),0);
        for (List li:res) {
            for (int i = 0; i <li.size() ; i++) {
                System.out.print(li.get(i)+",");
            }
            System.out.println();

        }


    }
    public static void subset(List<List<Integer>>res,int[] ast, List<Integer> cur, int index) {
        if(index>=ast.length)
        {
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        cur.add(ast[index]);
        subset(res,ast,cur,index+1);
        cur.remove(cur.size()-1);
        subset(res,ast,cur,index+1);

    }
}
