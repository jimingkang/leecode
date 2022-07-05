package com.andy.zju;

public class RemoveNthNOdeFromEndofList19 {
    public static void main(String[] args) {
        Node node=new Node();
        node.a=1;
        Node node2=new Node();
        node2.a=2;
        Node node3=new Node();
        node3.a=3;
        Node node4=new Node();
        node4.a=4;
        Node node5=new Node();
        node5.a=5;
        node.next=node2;
        node2.next=node3;
       // node3.next=node4;
       // node4.next=node5;
      Node n=  removeNthFromEnd(node,3);
    }
    public static Node removeNthFromEnd(Node head, int n) {
        Node origin = head;
        Node old = head;
        int length = 0;
        int i = 0;
        if (head.next == null)
            return null;
        while (head != null) {
            head = head.next;
            length++;
        }
        if (length == 2 && n == 2) {
            old = old.next;
            return old;

        } else if (length == 2 && n == 1) {
            old.next = null;
            return old;
        }
        if (length == n)
        {       old = old.next;
        return old;
    }
        head=origin;
        while(i++<length-n-1)
            head=head.next;
        Node tmp=head;
        if(head.next!=null)
        tmp.next=head.next.next;
        else
            tmp.next=null;

        return old;
    }

}
class ListNode {
    int val;
  ListNode next;
    ListNode(int x) { val = x; }
}
