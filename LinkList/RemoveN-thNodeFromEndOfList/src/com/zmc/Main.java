
/*

https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */



package com.zmc;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        removeNthFromEnd(head, 5);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return head;

        ListNode t1 = head, t2 = head;

        for (int i = 0; i < n; ++i) {
            if (t1 != null)
                t1 = t1.next;
        }

        if (t1 == null) {
            head = head.next;
            return head;
        }

        while (t1.next != null) {
            t1 = t1.next;
            t2 = t2.next;
        }

        if (t2.next != null)
            t2.next = t2.next.next;

        return head;
    }
}
