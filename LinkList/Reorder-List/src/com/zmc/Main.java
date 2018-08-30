/**
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 *
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * Example 2:
 *
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 *
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
        // test case
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        reorderList(head);
    }

    public static void reorderList(ListNode head) {
        if (head == null) return;

        ListNode tmp = head;
        int len = 0;
        while (tmp != null) {
            len ++;
            tmp = tmp.next;
        }

        tmp = head;
        for (int i = 0; i < len/2 - 1; ++i) {
            tmp = tmp.next;
        }

        // reverse the second half of list
        ListNode reversed = reverseList(tmp.next);
        tmp.next = null;

        tmp = head;
        ListNode next1, next2;

        // merge two list
        while (tmp.next != null) {

            next2 = reversed.next;
            next1 = tmp.next;
            tmp.next = reversed;
            reversed.next = next1;

            reversed = next2;
            tmp = next1;
        }

        if (reversed != null) tmp.next = reversed;
    }

    static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode tmp = head, pre = null, next;

        while (tmp.next != null) {

            next = tmp.next;
            tmp.next = pre;

            pre = tmp;
            tmp = next;
        }

        tmp.next = pre;

        return tmp;
    }
}
