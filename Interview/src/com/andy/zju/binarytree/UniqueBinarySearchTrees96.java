package com.andy.zju.binarytree;

public class UniqueBinarySearchTrees96 {
    public static int calculateNumTrees(int start, int end){
        //当出现这种情况之时，说明当前子树构造方式为0种，但计算总数是左乘右，故可以设置成1方便计算。
        if(start >= end) return 1;
        int count = 0;
        for(int i = start; i <= end; i++){
            int left = calculateNumTrees(start, i-1);
            int right = calculateNumTrees(i+1, end);
            count += left * right;
        }

        return count;
    }
    public static int numTrees(int n) {
        return calculateNumTrees(1, n);
    }

    public static void main(String[] args) {
        numTrees(3);
        System.out.println(numTrees(3));
    }
}
