package com.andy.zju.list;


import com.andy.zju.common.ListNode;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l12=new ListNode(2);
        ListNode l13=new ListNode(4);
        l1.next=l12;
        l12.next=l13;
        ListNode l2=new ListNode(1);
        ListNode l22=new ListNode(3);
        ListNode l23=new ListNode(4);
        l2.next=l22;
        l22.next=l23;
       ListNode res= mergeTwoLists(l1,l2);
       System.out.print(res);
    }
    public  static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newnode=null;
        ListNode head=null;
        if(l1==null&&l2==null)
            return null;
        else if(l1==null)
            return l2;
        else if(l2==null)
            return l1;

        if(l1.val<=l2.val)
        { newnode=l1;
            l1=l1.next;}
        else if(l1.val>l2.val)
        {
            newnode=l2;
            l2=l2.next;
        }
        head=newnode;
        while(l1!=null&&l2!=null)
        {
            if(l1.val<=l2.val)
            { newnode.next=l1;
                l1=l1.next;}
            else if(l1.val>l2.val)
            {
                newnode.next=l2;
                l2=l2.next;
            }

            newnode= newnode.next;

        }
        if(l1!=null)
            newnode.next=l1;
        else if(l2!=null)
            newnode.next=l2;
        return head;

    }
}
