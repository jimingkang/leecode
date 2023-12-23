package com.andy.leecode.binarytree;

import com.andy.leecode.common.TreeNode;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal103 {


/*    Example 1:

    Input: root = [3,9,20,null,null,15,7]
    Output: [[3],[20,9],[15,7]]
    Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []
*/
    public static List<List<Integer>> BinaryTreeZigzagLevelOrderTraversal(TreeNode root){
        ArrayList<List<Integer>> res=new  ArrayList<List<Integer>>();
       Queue<TreeNode> tmp=new LinkedList<TreeNode>();
        tmp.add(root);
        int count=0;
        while(!tmp.isEmpty()){
            ArrayList<Integer> list=new ArrayList<Integer>();

            int level_size=tmp.size();

           count++;
            for (int i =0 ; i <level_size; i++) {
                TreeNode node=tmp.poll();

                list.add(node.val);
                if(count%2==0) {
                    if (node.left != null) {
                        tmp.offer(node.left);
                    }
                    if (node.right != null) {
                        tmp.offer(node.right);

                    }
                }
                else{
                    if (node.right != null) {
                        tmp.offer(node.right);

                    }
                    if (node.left != null) {
                        tmp.offer(node.left);
                    }


                }
            }

           /* if(count%2==0) {
                list.add(node.val);
                list.add(node.val);
            }
            else{
                list.add(node.right.val);
                list.add(node.left.val);

            }*/
            res.add(list);
        }
        return res;

    }

    public static void main(String[]ss){
        TreeNode root=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);
        TreeNode node4=new TreeNode(6);
        root.left=node1;
        root.right=node2;
        node2.left=node3;
        node2.right=node4;
        List<List<Integer>> list=BinaryTreeZigzagLevelOrderTraversal(root);

        System.out.print(list);
    }
}
