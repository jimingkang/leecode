package com.andy.leecode.binarytree;

import com.andy.leecode.common.TreeNode;

import java.util.Arrays;

public class ConstructTreeFromPreAndInOrder105 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root=new TreeNode(preorder[0]);
        int i=0,j=0;

            for(;j<inorder.length;j++)
            {
                if(preorder[i]==inorder[j])
                {

                    TreeNode res=  buildroot(inorder,i,j,root);
                    i=j;
                }

                // TreeNode right=buildTree( preorder, inorder);

            }


return root;
    }
    public static  TreeNode buildroot(int[] inorder,int i,int j,TreeNode root) {

        if(i==j)
            return new TreeNode(inorder[i]);

        else {
            TreeNode left = buildroot(inorder, i, j, root);
            TreeNode right = buildroot(inorder, i, j, root);
            root.left = left;
            root.right = right;
            return root;
        }



    }
    public static void main(String[]ss){
        int[] preorder = {3,9,20,15,7};
        int []inorder = {9,3,15,20,7};

        TreeNode res=buildTree(preorder,inorder);

        System.out.print(res);
    }
}
