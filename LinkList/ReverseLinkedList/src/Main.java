
/*

https://leetcode.com/problems/reverse-linked-list/description/

Reverse a singly linked list.

Hint:
A linked list can be reversed either iteratively or recursively.
Could you implement both?

 */

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode pre = null, next;
        while (temp != null) {
            next = temp.next;
            temp.next = pre;
            pre = temp;
            temp = next;
        }

        return pre;
    }
}
