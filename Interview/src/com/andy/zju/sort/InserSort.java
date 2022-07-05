package com.andy.zju.sort;

import java.util.Arrays;

public class InserSort {
    public static void main(String [] ss){
        int []a=new int[]{1,4,7,6,3};
        inserSort(a);
        System.out.println(Arrays.toString(a));
    }
    static void   inserSort(int[] a){
        for (int i = 1; i <a.length ; i++) {
           int j=i-1;
           int tmp=a[i];
           while(a[j]>tmp) {
               a[j + 1] = a[j];
           j--;
           }
           a[j+1]=tmp;

        }

    }
}
