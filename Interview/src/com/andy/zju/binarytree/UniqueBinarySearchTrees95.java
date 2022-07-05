package com.andy.zju.binarytree;

import com.andy.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTrees95 {
  static  List<TreeNode> list=new ArrayList<>();
   static TreeNode root = null;
    public static TreeNode calculateNumTrees(int start, int end,TreeNode<Integer> root){

        if(root==null) root=new TreeNode();
        //当出现这种情况之时，说明当前子树构造方式为0种，但计算总数是左乘右，故可以设置成1方便计算。
        if(start >= end)
                {
                    TreeNode<Integer>  leave=new TreeNode();
                    leave.data=start;
                    return leave;
                }
        int count = 0;
        for(int i = start; i <= end; i++){
            TreeNode left = calculateNumTrees(start, i-1,root);
            TreeNode right = calculateNumTrees(i+1, end,root);
            root=new TreeNode();
            root.left=left;
            root.right=right;

            //count += left * right;
        }

        return root;
    }
    public static List<TreeNode> numTrees(int n) {
        calculateNumTrees(1, n,root);
        return list;
    }

    public static void main(String[] args) {
        numTrees(3);
        System.out.println(numTrees(3));
    }
}
