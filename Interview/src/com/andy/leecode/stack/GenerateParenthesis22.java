package com.andy.leecode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis22 {
    static List<String> list=new ArrayList<>();
    static Stack<String> stack= new Stack<String>();
    public static void main(String[] ags) {
        generateParenthesis(3);
    }
    public static List<String> generateParenthesis(int n) {

//backtrace("",0,0,n);
        backtrace2(0,0,n);
       return list;
    }
    public  static void backtrace(String ss,int left,int right,int n){
        if(ss.length()==n*2) {
            list.add(ss);
            return;
        }
        if (left < n)
            backtrace( ss+"(", left+1, right, n);
        //右括号不要超过左括号
        if (right < left)
            backtrace( ss+")", left, right+1, n);

    }
    public  static void backtrace2(int left,int right,int n){
        if(left==right &&right==n) {
            StringBuffer sb=new StringBuffer();
            Stack stack2= (Stack) stack.clone();

            while (!stack2.isEmpty())
                sb.append(stack2.pop());
            list.add(sb.toString());
            return;
        }
        if (left < n) {
            stack.push(")");
            backtrace2(left + 1, right, n);
            stack.pop();
        }
        //右括号不要超过左括号
        if (right < left) {
            stack.push("(");
            backtrace2(left, right + 1, n);
            stack.pop();
        }

    }
}
