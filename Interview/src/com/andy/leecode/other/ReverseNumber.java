package com.andy.leecode.other;

import com.andy.leecode.common.Node;

public class ReverseNumber {
    public static void main(String[] args) {
        int a=1534236469;
        System.out.println(reverseNumber(a));

    }
    static int reverseNumber(int a) {
        int num = 0;
        int tmp = a;
        if (a < 0)
            a = -a;
        Node head = new Node();
        Node previous = head;
        while (Math.abs(a) > 0) {
            num++;
            Node n = new Node();
            n.a = a % 10;
            previous.next = n;
            n.pre = previous;
            previous = n;
            a = a / 10;

        }
        Node newHead = head;
        while (newHead.next != null) {
            newHead = newHead.next;
        }
        Node tail = newHead;
        head = head.next;
        long new_a = 0;
        for (int  i = num; i >0; --i) {

                new_a += (Math.pow(10, i-1) * head.a);
            if(Math.abs(new_a)>(2147483647))
                return 0;

                head = head.next;

            }

            if (tmp < 0)
                new_a = -new_a;

            return (int)new_a;


        }

    }
