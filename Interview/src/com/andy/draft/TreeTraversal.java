package com.andy.draft;


import com.andy.ds.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversal<T> {
 //比较有创意的层序遍历，创建二叉树 //int []arr=[1,2,3,null,4,null, 5]，数组顺序是刚好层序遍历的次序，2 和3为1的子节点
 static int i=0;


 public static void main(String[] ss){
  TreeTraversal t=new TreeTraversal();
  Integer [] arr=new Integer[]{1,3,2,null,4,null, 5};
  TreeNode ret=  t.arrayToList(arr);
  System.out.println(maxDepth(ret));
 // levelOrder(ret);
 }
public static int maxDepth(TreeNode root){
  int dep=0;
  if(root!=null) {
   dep=Math.max(maxDepth(root.left),maxDepth(root.right))+1;
  }
  else
   dep= 0;
  return dep;
 }

 public static void levelOrder(TreeNode root){
  com.andy.ds.Queue q=new com.andy.ds.Queue();
  q.offer(root);
  TreeNode tmp=null;
  while( (tmp=(TreeNode)q.poll())!=null)
  {

   System.out.println(tmp.data);
   if(tmp.left!=null)
   q.offer(tmp.left);
   if(tmp.right!=null)
   q.offer(tmp.right);


  }

 }
 public static void preOrder(TreeNode root){
  if(root!=null) {
   System.out.println(root.data);
   preOrder(root.left);
   preOrder(root.right);
  }
 }
 public static void inOrder(TreeNode root){
  if(root!=null) {
   inOrder(root.left);
   System.out.println(root.data);

   inOrder(root.right);
  }
 }
 public void  createTree(TreeNode root, T[] array){
  Queue queue=new LinkedList<T>();
  TreeNode tmp1,tmp2;
  if(i==0){
   queue.offer(root);
   i++;
  }

  while(!queue.isEmpty()&&i<array.length){
   if(i<array.length&&array[i]!=null)
    tmp1=new TreeNode(array[i]);
   else
    tmp1=null;
   if((i+1)<array.length&&array[i+1]!=null)
    tmp2=new TreeNode(array[i+1]);
   else
    tmp2=null;
   i+=2;
   TreeNode<T> node=(TreeNode<T>)queue.poll();
   node.left=tmp1;
   node.right=tmp2;

   if(node.left!=null){
    queue.offer(node.left);
   }
   if(node.right!=null){
    queue.offer(node.right);
   }
  }

 }
 public  TreeNode arrayToList(T[] array){   //int []arr=[1,2,3,null,4,null, 5]

  TreeNode root=new TreeNode(array[0]);
  createTree(root,array);
  return root;
 }
}


