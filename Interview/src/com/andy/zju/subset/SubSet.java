package com.andy.zju.subset;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] ss){
        int[] test=new int[]{1,2,3};
       //int [] ast= asterriod_collision(test);
        List<List<Integer>>res=new ArrayList<>();
//subset(res,test,new ArrayList<>(),0);
        subset2(res,test,new ArrayList<>(),0);
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

    //method2
    public static void subset2(List<List<Integer>>res,int[] ast, List<Integer> cur, int index) {
      //  if(index>=ast.length)
      // {
            res.add(new ArrayList<Integer>(cur));
        //    return;
      //  }
        for (int i = index; i <ast.length ; i++) {
            cur.add(ast[index]);
            subset2(res,ast,cur,index+1);
            cur.remove(cur.size()-1);
          //  subset(res,ast,cur,index+1);
        }


    }
}
