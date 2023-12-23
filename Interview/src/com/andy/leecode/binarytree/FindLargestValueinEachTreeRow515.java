package com.andy.leecode.binarytree;

import com.andy.leecode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueinEachTreeRow515 {


/* Given the root of a binary tree, return an array of the largest value in each row of the tree (0-indexed).



Example 1:

Input: root = [1,3,2,5,3,null,9]
Output: [1,3,9]
Example 2:

Input: root = [1,2,3]
Output: [1,3]
*/


    public static List<Integer> findLargestValueinEachTreeRow(TreeNode root) {
        List<Integer> res=new  ArrayList<Integer>();
        Queue<TreeNode> tmp=new LinkedList<TreeNode>();
        tmp.add(root);
        int count=0;
        res.add(root.val);
        while(!tmp.isEmpty()){
            //ArrayList<Integer> list=new ArrayList<Integer>();

            int level_size=tmp.size();
            int max=0;
            count++;
            for (int i =0 ; i <level_size; i++) {
                TreeNode node=tmp.poll();



                    if (node.left != null) {
                        tmp.offer(node.left);
                        if(node.left.val>max)
                            max=node.left.val;
                    }
                    if (node.right != null) {
                        tmp.offer(node.right);
                        if(node.right.val>max)
                            max=node.right.val;

                    }



                }
            res.add(max);

        }
        res.remove(res.size()-1);
        return res;
    }

    public static boolean isLeaf(TreeNode root) {
        if(root.left==null&&root.right==null)
            return true;
        else
            return false;
    }


    public static void main(String[]ss){
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(6);
        root.left=node1;
        root.right=node2;

       node1.left=node3;
        node1.right=node4;


        System.out.print(findLargestValueinEachTreeRow(root));
    }
}
