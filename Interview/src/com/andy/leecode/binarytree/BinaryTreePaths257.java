package com.andy.leecode.binarytree;

import com.andy.leecode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePaths257 {


/*Given the root of a binary tree, return all root-to-leaf paths in any order.

A leaf is a node with no children.



Example 1:


Input: root = [1,2,3,null,5]
Output: ["1->2->5","1->3"]
Example 2:

Input: root = [1]
Output: ["1"]
*/

    public static List<String> binaryTreePaths(TreeNode root){
        List<String> res=new  ArrayList<String>();
        StringBuffer tmp=new StringBuffer();
        dfs(root,res,tmp);
        return res;
    }
    public static void dfs(TreeNode root,List<String> res,StringBuffer tmp) {

        if(root==null) {

            return;
        }
        tmp.append(root.val+"->");
        if(root.left==null&&root.right==null)
            if(!res.contains(tmp)) {
                res.add(tmp.substring(0,tmp.length()-2).toString());
            }


        dfs(root.left,res,tmp);
        //tmp.remove(tmp.size()-1);
        dfs(root.right,res,tmp);
        tmp.deleteCharAt(tmp.length()-1);
       tmp.deleteCharAt(tmp.length()-1);
        tmp.deleteCharAt(tmp.length()-1);

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


        System.out.print(binaryTreePaths(root));
    }
}
