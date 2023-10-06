package com.andy.leecode.binarytree;
import com.andy.leecode.common.*;

import java.util.LinkedList;

public class BinaryTreeStackTraversal {
    public static void preOrderStackTraversal(TreeNode root){
        TreeNode pNode=root;
        LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
        while(pNode!=null||!stack.isEmpty()){
            if(pNode!=null) {
                System.out.print(pNode.val+"->");
                stack.push(pNode);
                pNode = pNode.left;
            }else{
                TreeNode node=stack.pop();
                pNode=node.right;
            }

        }

    }
    public static void InOrderStackTraversal(TreeNode root){
        TreeNode pNode=root;
        LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
        while(pNode!=null||!stack.isEmpty()){
            if(pNode!=null) {

                stack.push(pNode);
                pNode = pNode.left;
            }else{
                TreeNode node=stack.pop();
                System.out.print(node.val+"->");
                pNode=node.right;
            }

        }

    }
    public static void PostOrderStackTraversal(TreeNode root){
        TreeNode cur,pre=null;

        LinkedList<TreeNode> stack=new LinkedList<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            cur=stack.peek();
            if((cur.left==null&&cur.right==null)||
             pre!=null&&(pre==cur.left||pre==cur.right)
            ){
                System.out.print(cur.val+"->");
                stack.pop();
                pre = cur;
            }else{
                if(cur.right!=null)
               stack.push(cur.right);
                if(cur.left!=null)
                    stack.push(cur.left);
            }

        }

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
        PostOrderStackTraversal(n1);

    }
}
