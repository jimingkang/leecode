package com.andy.zju.other;

import com.andy.ds.Stack;

import java.util.ArrayList;
import java.util.List;

public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int []a={1,8,6,2,5,4,8,3,7};
        int sum=0;
        int l=0;
        int r=a.length-1;

       // stack.push(0);
        while(l<r){
             sum=Math.max(sum,Math.max(a[l],a[r])*(r-l));
             if(a[l]<a[r])
                 l++;
             else
                 r--;

        }

    System.out.println(sum);
    }
}
