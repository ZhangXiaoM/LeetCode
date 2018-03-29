
/*

https://leetcode.com/problems/rotate-list/description/

Given a list, rotate the list to the right by k places, where k is non-negative.


Example:

Given 1->2->3->4->5->NULL and k = 2,

return 4->5->1->2->3->NULL.

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
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        rotateRight(head, 2);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;

        int n = 0;
        ListNode slow = head, fast = head;
        while (fast != null) {
            n ++;
            fast = fast.next;
        }
        if (k % n == 0)
            k = n;
        else k %= n;

        fast = head;
        for (int i = 0; i < k; ++i) {
            fast = fast.next;
        }

        if (fast == null) {
            return head;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode pHead = slow.next;
        fast.next = head;
        slow.next = null;

        return pHead;
    }
}
