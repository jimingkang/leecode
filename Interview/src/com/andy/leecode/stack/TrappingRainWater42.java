package com.andy.leecode.stack;

import java.util.LinkedList;

public class TrappingRainWater42 {
    public static void main(String[] args) {
        int [] a=new int[]{0,1,0,0,2,1,0,1,3,2,1,2,1};
        LinkedList<Integer> stack=new LinkedList<Integer>();
        int sum=0;
        //stack.add(0);
        for (int i = 0; i <a.length ;) {
            while(!stack.isEmpty()&&(a[stack.peek()]<a[i])){
                int h=a[(int)stack.peek()];
                stack.pop();
                if (stack.isEmpty()) { // 栈空就出去
                    break;
                }
                int distance = i - (int)stack.peek() - 1; //两堵墙之前的距离。
                int min = Math.min(a[(int)stack.peek()], a[i]);
                sum = sum + distance * (min - h);
            }
            stack.push(i);
            i++;

        }
        System.out.println(sum);


    }
}
