package com.andy.zju.stack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
   static  List<String> list=new ArrayList();
    public static List<String> generateParenthesis(int n) {
        for (int i = 0; i <n ; i++) {
           helper(n-i,i);

        }

        return list;
    }
    public static void helper(int i,int j)
    {StringBuffer sb=new StringBuffer();
        if(i==1)
        {String s=new String("()");
            list.add(s);

        }
        for (int m = 0; m <i ; m++) {

        }






    }

    public static void main(String[] args) {
      list=  generateParenthesis(3);
        System.out.println(list);
    }
}
