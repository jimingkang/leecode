package com.andy.leecode.binarytree;

import com.andy.leecode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinDepthOfTree111 {


/* Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.
Input: root = [3,9,20,null,null,15,7]
Output: 2
Example 2:

Input: root = [2,null,3,null,4,null,5,null,6]
Output: 5
*/


    public static int maxDepthOfTree(TreeNode root) {
        if(root==null)
            return 0;


         int  leftlen= 1+ maxDepthOfTree(root.left);

          int  rightlen=1+maxDepthOfTree(root.right);

        return Math.max(leftlen,rightlen);
    }
    public static int minDepthOfTree(TreeNode root) {
        if(root==null)
            return 0;


        int  leftlen= 1+ minDepthOfTree(root.left);

        int  rightlen=1+minDepthOfTree(root.right);
        if (leftlen==1)
            return rightlen;
        else if (rightlen==1)
            return leftlen;
        else
        return Math.min(leftlen,rightlen);
    }
    public static boolean isLeaf(TreeNode root) {
        if(root.left==null&&root.right==null)
            return true;
        else
            return false;
    }
    public static int minDepthOfTree111(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> tmp = new LinkedList<TreeNode>();
        tmp.add(root);

        int count = 0;

        while (!tmp.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<Integer>();

            int level_size = tmp.size();


            for (int i = 0; i < level_size; i++) {
                TreeNode node = tmp.poll();

                if (node.left == null&&node.right != null) {
                    return count;
                }

                if (node.left != null) {
                    tmp.offer(node.left);

                }
                if (node.right != null) {
                    tmp.offer(node.right);
                }




            }
            count++;

        }


        return count;

    }

    public static void main(String[]ss){
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(6);
        root.left=node1;
        //root.right=node2;

       node1.left=node3;
        node3.left=node2;
      // int depth=minDepthOfTree111(root);  //method 1:queue

        System.out.print(minDepthOfTree(root));  //method 2:iterator
    }
}
