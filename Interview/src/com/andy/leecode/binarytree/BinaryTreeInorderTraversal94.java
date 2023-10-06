package com.andy.leecode.binarytree;

import com.andy.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal94 {
   static List<Integer> list=null;
    public static void main(String[] args) {
        TreeNode<Integer> node=new TreeNode();
        TreeNode<Integer> left=new TreeNode();
        TreeNode<Integer> right=new TreeNode();
        node.data=1;
        node.right=right;
        right.data=2;
        right.left=left;
        left.data=3;

        list=inorderTraversal(node);

    }

    public static List<Integer> inorderTraversal(TreeNode<Integer> root) {

        if(list==null)
            list=new ArrayList<Integer>();
        if(root!=null)
        {
            inorderTraversal(root.left);
            list.add(root.data);
            inorderTraversal(root.right);
        }
        return list;
    }
}
