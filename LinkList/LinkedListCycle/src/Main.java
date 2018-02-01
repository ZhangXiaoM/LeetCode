
/*

https://leetcode.com/problems/linked-list-cycle/description/

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

 */


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;

        ListNode slow = head, fast = head;

        while (slow != null && fast != null) {

            slow = slow.next;
            if (fast.next == null) return false;
            fast = fast.next.next;

            if (slow == fast) return true;
        }

        return false;
    }
}
