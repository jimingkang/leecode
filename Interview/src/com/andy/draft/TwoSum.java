package leecode;

/*
https://leetcode.com/problems/two-sum/description/
Given nums = [2, 7, 11, 15], target = 9,
        Because nums[0] + nums[1] = 2 + 7 = 9,
        return [0, 1].*/
public class TwoSum {

        public int[] twoSum(int[] nums, int target) {
            int[] s=new int[2];
            for (int i=0;i<nums.length;i++) {
                for (int j=i+1;j<nums.length;j++) {
                    if(nums[i]+nums[j]==target) {
                        s[0] = i;
                        s[1] = j;
                    }
                }

            }

            return s;
        }
        public static void main(String[]ss){
           int[] nums =new int[] {2, 7, 11, 15};
            TwoSum twosum=new TwoSum();
            int[] res= twosum.twoSum(nums,9);
            System.out.println();
        }
}
