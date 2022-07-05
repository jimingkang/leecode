package com.andy.zju.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String [] ss){
        int []a=new int[]{1,4,7,6,3};
        bubbleSort(a);
        System.out.println(Arrays.toString(a));
    }
    static void   bubbleSort(int[] a){
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j<=i ; j++) {
                if (a[j] > a[i]) {
                  int tmp=a[i];
                    a[i]=a[j];
                    a[j ] = tmp;

                }
            }


        }

    }
}
