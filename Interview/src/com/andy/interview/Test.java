package com.andy.interview;

import java.util.Arrays;
import java.util.stream.Stream;

public class Test {
    public static void main(String[]ss){



 int [] arr={1,2,5,2,7,9};
        Arrays.stream(arr).forEach((x)->System.out.println(x));
    }
    public static int profit(int[]arr){
        int ret=0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>arr[i-1])
                ret +=arr[i]-arr[i-1];

        }
        return ret;
    }
}
