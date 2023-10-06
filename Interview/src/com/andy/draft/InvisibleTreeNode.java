package com.andy.draft;

import java.util.ArrayList;
import java.util.List;

public class InvisibleTreeNode {
    public static void main(String []ss){
        List<String> a=new ArrayList<String>();
        Tree root=new Tree(1);
         root.l=new Tree(2);
        root.r=new Tree(3);
        a=binaryTreePaths(root);
        for (String aa:
             a) {
            System.out.println(ss);

        }
    }

    static List<String> binaryTreePaths(Tree root) {
        List<String> res = new ArrayList<String>();
        if (root!=null) helper(root, "", res);//res作为全局返回 ，字符串“”不断迭代追加，为空时（叶子结点）添加到res里
        return res;
    }
    public static void helper(Tree root,String res,List a){
        if(root.l==null&&root.r==null) {
            a.add(res+root.x);
            }
            if(root.l!=null)
                helper(root.l,res+root.x+"->",a);
            if(root.r!=null)
                helper(root.r,res+root.x+"->",a);
        }


}
class Tree{
    public Tree(int x){
        this.x=x;
    }
    int x;
    Tree l;
    Tree r;
}

