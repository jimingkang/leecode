package com.andy.leecode.binarytree;

import com.andy.leecode.common.TreeNode;

public class RecoverTreeNode99 {
    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode  n2=new TreeNode(2);
        TreeNode n4=new TreeNode(4,n2,null);
        TreeNode  n3=new TreeNode(3,n1,n4);
        System.out.println(n3);


    }
    public static void recoverTree(TreeNode root) {

        if(root==null)
            return;
        TreeNode left= Max(root.left);
        TreeNode right= Min(root.right);
        if(left!=null&& right!=null&&left.val>root.val&&right.val<root.val)
        {
            int tmp=right.val;
            right.val=left.val;
            left.val=tmp;

        }
        if(left!=null&& right!=null&&left.val>root.val)
        {
            int tmp=root.val;
            root.val=left.val;
            left.val=tmp;

        }
        if(right!=null&& right!=null&&right.val<root.val)
        {
            int tmp=root.val;
            root.val=right.val;
            right.val=tmp;

        }


        recoverTree(root.left);
        recoverTree(root.right);


    }
    public static TreeNode Max(TreeNode root){
        if(root==null)
            return null;

        TreeNode left;
        TreeNode right;
        TreeNode max=root;
        left= Max(root.left);
        right = Max(root.right);
        if(left!=null&&root.val<left.val) {
            max=left;

        }
         if(right!=null&&root.val<right.val) {
            max=right;
        }
        return max;



    }
    public static TreeNode Min(TreeNode root){
        if(root==null)
            return null;

        TreeNode left;
        TreeNode right;
        TreeNode min=root;
        left= Min(root.left);
        right = Min(root.right);
        if(left!=null&&root.val>left.val) {
            min=left;

        }
        if(right!=null&&root.val>right.val) {
            min=right;
        }
        return min;



    }
}

