package com.andy.zju.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String [] ss){
        int []a=new int[]{1,7,4,6,3};
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }
    static void   mergeSort(int[] arr){
        int []temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr,0,arr.length-1,temp);

    }
    static void sort(int[]a,int Left,int Right,int []temp){
        if(Left<Right) {
            int Center = (Left + Right) / 2;
            sort(a, Left, Center, temp);
            sort(a, Center + 1, Right, temp);
            merge(a, Left, Center, Right, temp);
        }
    }
    static void merge(int[]a,int Left,int Mid,int Right,int []tmp) {
        int i=Left;
        int j=Mid+1;
        int t=0;
        while(i<=Mid&&j<=Right) {
            if (a[i] < a[j])
                tmp[t++] = a[i++];
            else
                tmp[t++] = a[j++];
        }
        while(i<=Mid)
            tmp[t++] = a[i++];
        while(j<=Right)
            tmp[t++] = a[j++];

        t=0;
        while(Left <= Right){
            a[Left++] = tmp[t++];
        }




    }
}
