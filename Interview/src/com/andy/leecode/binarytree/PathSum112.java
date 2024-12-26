package com.andy.leecode.binarytree;

import com.andy.leecode.common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class PathSum112 {

    public static void main(String[] args) {
        TreeNode n1=new TreeNode(2);
        TreeNode  n2=new TreeNode(1,n1,null);
       // TreeNode n4=new TreeNode(4,n2,null);
       // TreeNode  n3=new TreeNode(3,n1,n4);
        System.out.println(hasPathSum(n2,1));


    }
    public static boolean hasPathSum(TreeNode root, int targetSum) {
      int sum=0;
      if(root==null)
      return false;

       boolean res= pathSum( root,  targetSum,sum);
      return res;
      
        
    }
     public static boolean pathSum(TreeNode root, int targetSum,int sum){


        if(root==null)
        return true;
       // if(root==null)
       // return false;

       boolean l=false;
       boolean r=false;

        sum=root.val+sum;
         if(sum==targetSum)
             return true;
        l=pathSum( root.left,  targetSum,sum);

        if(l==false)  
        {
            r=pathSum( root.right,  targetSum,sum);
            if(r)
                return true;
            else
                return false;

        } 
        else
            return true;
        

 


     }
}