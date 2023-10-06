package com.andy.draft;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsterriodCollision735 {
    public static void main(String[] ss){
        int[] test=new int[]{11,9,10, 2,-8,-5, 3};
       int [] ast= asterriod_collision(test);
        for (int i = 0; i <ast.length ; i++) {
            System.out.println(ast[i]);
        }


    }
    public static int [] asterriod_collision(int[] ast){
        Deque<Integer> stack=new ArrayDeque<Integer>();
         for (int i = 0; i <ast.length ; i++) {
             if(ast[i]>0)
                 stack.push(ast[i]);
             else {

                 while (!stack.isEmpty() && stack.peek() <= -ast[i]) {
                     stack.pop();
                 }

             //    if(stack.isEmpty()||stack.peek()<0)
             //        stack.push(ast[i]);
             }

        }
         int[] ret=new int[stack.size()];
        for (int i = stack.size()-1; i >=0 ; i--) {
            ret[i]=stack.pop();
        }
        return ret;
    }
}
