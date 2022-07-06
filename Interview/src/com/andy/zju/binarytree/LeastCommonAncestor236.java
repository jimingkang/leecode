package com.andy.zju.binarytree;

import com.andy.zju.common.TreeNode;

public class LeastCommonAncestor236 {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {


        if (root == null || root.val == q.val || root.val == p.val) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null)
            return root;

        return l != null ? l : r;
    }

    public static void main(String[] args) {
        TreeNode n7=new TreeNode(7);
        TreeNode  n8=new TreeNode(8);
        TreeNode  n5=new TreeNode(5);
        TreeNode n4=new TreeNode(4);
        TreeNode n2=new TreeNode(2,n4,n5);
        TreeNode  n6=new TreeNode(6,n7,n8);
        TreeNode n3=new TreeNode(3,null,n6);
        TreeNode  n1=new TreeNode(1,n2,n3);
        System.out.print(lowestCommonAncestor(n1,n7,n8).val);
    }
}
