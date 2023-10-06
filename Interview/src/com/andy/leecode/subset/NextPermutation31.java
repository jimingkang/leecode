package com.andy.leecode.subset;

public class NextPermutation31 {
    public static void main(String[] args) {
        NextPermutation31 n=new NextPermutation31();
       int[] nums=new int[]{1,3,2};
        //n.patition(nums,0,2);
       // bubbleSort(nums);
        System.out.println();
       n.nextPermutation(nums);
        System.out.println(nums);
    }
    public void nextPermutation(int[] nums) {
        int i=-1;
        int cnt=0;
        if(nums.length==1)
            return;
        if(nums.length==2)
        {
            if(nums[1]>nums[0])
            {
                int tmp=nums[0];
                nums[0]=nums[1];
                nums[1]=tmp;
            }
            return;
        }
//????怎么解决
        /*for ( i = nums.length-1 ; i >1; i--) {
            if(nums[i]>nums[i-1])
            {
                cnt++;
                int tmp=nums[i-1];
                nums[i-1]=nums[i];
                nums[i]=tmp;
                break;
            }

        }*/
        if(cnt==0)
            bubbleSort(nums);

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
    public  void quickSort(int[]a,int begin,int end) {
        if (begin < end) {
            int p = patition(a, begin, end);
            quickSort(a, begin, p - 1);
            quickSort(a, p + 1, end);
        }
    }
    public  int patition(int[] a,int begin,int end){

        int res=-1;
        int i=begin-1;
        int pivot=a[end];
        for (int k = begin; k < end-1; k++) {
            if(a[k]<=pivot){
                i++;
                swap(a,i,k);
            }
        }
        swap(a,i+1 ,end);
        return i+1;

    }
    public  void swap(int [] a, int i,int j){
        int tmp=0;
        tmp=a[i];
        a[i]=a[j];
        a[j]=tmp;
    }
}
