package com.andy.zju.array;

public class MidianOfTwoArray {
    public static void main(String[] args) {
        int[]a=new int[]{1,3};
        int[]b=new int[]{};
        System.out.println(findMedianSortedArrays(a,b));
    }


        public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

            if(nums1!=null && nums2!=null){

                int [] newArr=null;
                if(nums1.length==0)
                { newArr=nums2;
                    if(newArr.length%2==0)
                    {
                        return (newArr[newArr.length/2-1]+newArr[newArr.length/2])/2.0;
                    }
                    else{
                        return newArr[newArr.length/2];
                    }
                }
                else if(nums2.length==0)
                {
                    newArr=nums1;
                 //   newArr=nums2;
                    if(newArr.length%2==0)
                    {
                        return (newArr[newArr.length/2-1]+newArr[newArr.length/2])/2.0;
                    }
                    else{
                        return newArr[newArr.length/2];
                    }}
                else{
                    int len=nums1.length+nums2.length;
                    newArr=new int[len];
                    int i=0,j=0;
                    for (int m= 0; m <newArr.length ; ) {
                        while(i<nums1.length&&j< nums2.length)
                        {
                            if(nums1[i]<nums2[j])
                            {
                                newArr[m]=nums1[i];

                                i++;
                            }else{
                                newArr[m]=nums2[j];

                                j++;
                            }
                            m++;
                        }
                        if(i< nums1.length){
                            for (; i< nums1.length; m++,i++) {
                                newArr[m]=nums1[i];
                            }

                        }

                        if(j< nums2.length){
                            for (; j< nums2.length; m++,j++) {
                                newArr[m]=nums2[j];
                            }

                        }


                    }
                    if(len%2==0)
                    {
                        return (newArr[len/2-1]+newArr[len/2])/2.0;
                    }
                    else{
                        return newArr[len/2];
                    }


                }



            }
            return 0;

    }
}
