package leecode;
/*Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
        Example:
        Given array nums = [-1, 2, 1, -4], and target = 1.
        The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/


public class Three_Sum_Closest {
    public static void main(String[]ss){
int[] a=new int[]{1,-2,3,4};
        System.out.println(Sum3Closest(a,3));
    }
    public static int Sum3Closest(int[]a,int target){
        int max=a[0]+a[1]+a[2];;
        int tmp_sum=0;
        for(int i=1;(i+1)<a.length&&(i+2)<a.length&&i<a.length-3;i++){
            tmp_sum+=a[i]+a[i+1]+a[i+2];

            int tmp_target=(tmp_sum-target)>0?tmp_sum-target:target-tmp_sum;
            int tmp_max=(max-target)>0?max-target:target-max;
            if(tmp_target<tmp_max)
                max=tmp_target;
            if(tmp_sum<0)
                tmp_sum=0;
        }
        return max;
    }
}
