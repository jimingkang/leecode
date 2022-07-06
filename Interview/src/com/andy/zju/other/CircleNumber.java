package com.andy.zju.other;

import com.andy.zju.common.Node;

public class CircleNumber {
    public static void main(String [] ss){
        System.out.print("result:"+circleNumber(1534236469));
    }
    static boolean circleNumber(int a){
        int num=0;
        if(a<0)
            return false;
        Node head=new Node();
        Node previous=head;
        while(Math.abs(a)>0){
            num++;
            Node n=new Node();
            n.a=a%10;
            previous.next=n;
            n.pre=previous;
            previous=n;
            a=a/10;

        }
        Node newHead=head;
       while(newHead.next!=null)
       {
           newHead=newHead.next;
       }
       Node tail=newHead;
       head=head.next;
       while(num-->0)
       {
           if(tail.a!=head.a)
           {
               return false;
           }
           tail=tail.pre;
           head=head.next;

       }

      //  System.out.print(head);

return true;
    }
  //  public Node  reverseLinkNode(Node node){
 //       Node newNode=node;
 //   }

}

