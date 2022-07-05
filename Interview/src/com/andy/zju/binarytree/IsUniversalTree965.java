package com.andy.zju.binarytree;

import com.andy.ds.TreeNode;

public class IsUniversalTree965 {
    public static void main(String[] args) {

    }
    int count=0;
    public int UniversalTree(TreeNode node){
        if(node==null)
            return 0;

       count=UniversalTree(node.left)+UniversalTree(node.right);
       if(isUnique(node))
           count+=1;
       return count;
    }
    public  boolean isUnique(TreeNode
                                     node){
        if(node==null)
            return true;
         if(node.left!=null&&node.left.data!=node.data)
            return false;
        if(node.right!=null&&node.right.data!=node.data)
            return false;
        if(isUnique(node.left)&&isUnique(node.right))
            return true;
        return false;
    }
}

