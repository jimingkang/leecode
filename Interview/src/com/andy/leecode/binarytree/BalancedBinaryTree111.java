package com.andy.leecode.binarytree;

import com.andy.leecode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BalancedBinaryTree111 {


/* Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.
Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
*/

    public static int depth(TreeNode root) {
        if(root==null)
            return 0;


        int  leftlen= 1+ depth(root.left);

        int  rightlen=1+depth(root.right);

        return Math.max(leftlen,rightlen);
    }


    //method 1
    public static boolean balancedBinaryTree(TreeNode root) {
        if(root==null)
            return true;


        boolean   bright=balancedBinaryTree(root.right);
        boolean   bleft=balancedBinaryTree(root.left);
        return Math.abs(depth(root.left)-depth(root.right))<=1 &&bright&&bleft;



    }


    //method 2
    public static int dfsHeight(TreeNode root) {
        if(root==null)
            return 0;


        int  leftlen=  dfsHeight(root.left);
       // if (leftlen == -1) return -1;

        int  rightlen=dfsHeight(root.right);
       // if (rightlen == -1) return -1;

        if(Math.abs(leftlen-rightlen)>1)
            return -1;

        return Math.max(leftlen,rightlen)+1;
    }

  static  boolean isBalanced(TreeNode root) {
        return dfsHeight (root) != -1;
    }







    public static void main(String[]ss){
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(5);

        TreeNode node5=new TreeNode(6);
        TreeNode node6=new TreeNode(7);
        root.left=node1;
        root.right=node2;

       node1.left=node3;
        node1.right=node4;
       node3.left=node5;
        node3.right=node6;
        System.out.print(balancedBinaryTree(root));  //method 1


        System.out.print(isBalanced(root));  //method 2

    }
}
