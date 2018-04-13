
/*

https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

Given a sorted linked list, delete all nodes that have duplicate numbers,
leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
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
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next = new ListNode(4);
        head = deleteDuplicates(head);

    }

    public static ListNode deleteDuplicates(ListNode head) {
        head = deleteHead(head);

        if (head == null || head.next == null) return head;

        ListNode temp = head.next, pre = head;

        while (temp != null && temp.next != null) {
            if (temp.next.val != temp.val) {
                temp = temp.next;
                pre = pre.next;
            } else {
                pre.next = deleteHead(temp);
                temp = pre.next;
            }
        }



        return head;
    }


    static ListNode deleteHead(ListNode head) {
        if (head == null || head.next == null) return head;

        int cnt = 0;
        while (head.next != null && head.next.val == head.val) {
            head = head.next;
            cnt ++;
        }

        if (cnt != 0) {
            head = head.next;
            return deleteHead(head);
        } else {
            return head;
        }
    }
}
