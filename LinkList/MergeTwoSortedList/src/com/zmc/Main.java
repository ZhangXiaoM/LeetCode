
/*

https://leetcode.com/problems/merge-two-sorted-lists/description/

Merge two sorted linked lists and return it as a new list.
The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
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
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode p1 = l1, p2 = l2;

        ListNode head;
        if (p1.val <= p2.val) {
            head = new ListNode(p1.val);
            p1 = p1.next;
        } else {
            head = new ListNode(p2.val);
            p2 = p2.next;
        }

        ListNode temp = head;

        while (p1 != null || p2 != null) {

            if (p1 == null) {
                temp.next = p2;
                break;
            }
            if (p2 == null) {
                temp.next = p1;
                break;
            }

            ListNode node = new ListNode(0);
            if (p1.val <= p2.val) {
                node.val = p1.val;
                p1 = p1.next;
            } else {
                node.val = p2.val;
                p2 = p2.next;
            }
            temp.next = node;
            temp = node;
        }

        return head;
    }
}
