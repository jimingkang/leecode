package com.andy.draft;

public class ReverseListBetween {

    public static void main(String[]ss){
        int[] a=new int[]{1,2,3,4};
        ListNode aa=new ListNode(1);
        aa.next=new ListNode(2);
     aa.next.next=new ListNode(4);
        aa.next.next.next=new ListNode(5);
        reverseBetween(aa,2,3);

        System.out.println(a);
    }
    public static void reversrArray(int[] a){
        for(int i=0;i<a.length/2;i++)
        {
            int mid=a.length/2;
            int tmp=a[i];
            a[i]=a[a.length-i-1];
            a[a.length-i-1]=tmp;

        }
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre=head;
        ListNode  pre_m=head;
        int [] a=new int[n-m+1];
        for(int i=0;i<n;i++)
        {
            System.out.print(pre.val+" ");

            if(i==(m-1))
                pre_m=pre;
            if(i>=(m-1))
            {

                a[i-m+1]=pre.val;


            }


            pre=pre.next;
        }

        reversrArray(a);
        for(int i=0;i<a.length;i++)
        {
            pre_m.val=a[i];
            pre_m=pre_m.next;

        }

        return head;
    }

}

