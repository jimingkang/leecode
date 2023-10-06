package com.andy.draft;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemp739 {
    public static void main(String[] ss){
        int[] test=new int[]{11,9,10, 2,-8,-5, 3};
       int [] ast= daily_temp(test);
        for (int i = 0; i <ast.length ; i++) {
            System.out.println(ast[i]);
        }


    }
    public static int [] daily_temp(int[] ast){
        Deque<Integer> stack=new ArrayDeque<Integer>();
        int[] res=new int[ast.length];
        for (int i = ast.length-1; i >=0 ; i--) {


                 while (!stack.isEmpty() && ast[stack.peek()] <= ast[i]) {
                     stack.pop();
                 }
                 if(stack.isEmpty())
                     res[i]=0;
                 else
               res[i]=stack.peek()-i;

                     stack.push(i);


        }

        return res;
    }
}
