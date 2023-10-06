package com.andy.draft;

public class ReverseLinkedlist {
    public static void main(String[] ss){
      //  int[] test=new int[]{11,9,10, 2,-8,-5, 3};
        Mylist node=new Mylist(1);
        Mylist node2=new Mylist(2);
        Mylist node3=new Mylist(3);
        node.next=node2;
        node2.next=node3;
       Mylist ast= reverse_linkedlist(node);
System.out.println(ast.next.value);


    }
    public static Mylist reverse_linkedlist(Mylist head){
if(head==null ||head.next==null)
    return head;
        Mylist rever_head=reverse_linkedlist(head.next);
        head.next.next=head;
        head.next=null;
        return rever_head;
    }
}
class Mylist{
    int value;
    Mylist next;
    Mylist(int value){
        this.value=value;
    }
}
