
/*

https://leetcode.com/problems/reverse-linked-list-ii/description/

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

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
        head = reverseBetween(head, 2, 5);
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || n <= m) return head;

        ListNode pre_m = null, behind_n = null, temp = head;
        for (int i = 1; i < m - 1; ++i) {
            temp = temp.next;
        }
        pre_m = m == 1? null: temp;
        temp = head;
        for (int i = 0; i < n; ++i) {
            temp = temp.next;
        }
        behind_n = temp;

        temp = pre_m == null? head: pre_m.next;
        ListNode first = temp;

        for (int i = 0; i < n - m + 1; ++i) {
            ListNode next = temp.next;
            if (i == 0) {
                temp.next = behind_n;
            } else {
                temp.next = first;
            }
            first = temp;
            temp = next;
        }
        if (pre_m != null) {
            pre_m.next = first;
            return head;
        } else {
            return first;
        }
    }
}
