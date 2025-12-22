
//https://leetcode-cn.com/problems/maximum-subarray/
package com.andy.leecode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LagestIncreasingSubsequence300 {
  //Subsequence可以不连续,但是这里要求递增
    public static void main(String[] args) {
        int[] a = new int[]{-2, -3, 1, 4, -1, 2, 1, -5, 4};
        int[] newa = new int[a.length];
        int[] pos = new int[a.length];
        int[] prev = new int[a.length];
        int len=0;
        for (int i = 0; i < a.length; i++) {
            int l=0;
            int r=len;

            while(l<r) {
                int m=(l+r)/2;
                if(newa[m]<a[i])
                {
                    l=m+1;
                }else{
                    r=m;
                }

            }
            newa[l]=a[i];
            pos[l] = i;
            prev[i] = (l > 0) ? pos[l - 1] : -1;
            if (l == len) {
                len++;
            }

           // Arrays.stream(newa).forEach(System.out::print);
            System.out.println(Arrays.toString(Arrays.copyOf(newa, len)));

        }

        // 回溯 LIS
        List<Integer> lis = new ArrayList<>();
        int idx = pos[len - 1];
        while (idx != -1) {
            lis.add(a[idx]);
            idx = prev[idx]; //prev = [-1, -1*, 1, 2, 1*, 4, 4*, -1, 6*]回溯
        }
        Collections.reverse(lis);

        System.out.println("LIS length = " + len);
        System.out.println("LIS sequence = " + lis);

    }
}
