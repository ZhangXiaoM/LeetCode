
/*

https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
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

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = head;

        while (temp != null) {
            if (temp.next == null) break;
            if (temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }
}
