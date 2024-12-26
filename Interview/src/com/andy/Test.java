package com.andy;

public class Test {
    public static void main(String[] args) {
        Test t=new Test();

        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(t.maxArea(height));
    }

    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int max=-1;
        while(i<j){
            max=Math.max(max,Math.min(height[i],height[j])*(j-i));
            if(height[i]<height[j])
            i++;
            else
            j--;

        }
        return max;

    }
}


