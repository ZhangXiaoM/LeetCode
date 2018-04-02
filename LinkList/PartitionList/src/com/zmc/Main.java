
/*

https://leetcode.com/problems/partition-list/description/

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.


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
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        partition(head, 3);
    }

    // time complexity O(N) space complexity O(1)
    public static ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode pSmall = null;
        ListNode pLager = null;
        ListNode pSmallHead = null;
        ListNode pLagerHead = null;

        while (head != null) {

            if (head.val < x) {
                if (pSmall == null) {
                    pSmallHead = new ListNode(head.val);
                    pSmall = pSmallHead;
                } else {
                    pSmall.next = new ListNode(head.val);
                    pSmall = pSmall.next;
                }
            } else {
                if (pLager == null) {
                    pLagerHead = new ListNode(head.val);
                    pLager = pLagerHead;
                } else {
                    pLager.next = new ListNode(head.val);
                    pLager = pLager.next;
                }
            }

            head = head.next;
        }

        if (pSmall != null) pSmall.next = pLagerHead;

        return pSmallHead != null? pSmallHead: pLagerHead;
    }
}
