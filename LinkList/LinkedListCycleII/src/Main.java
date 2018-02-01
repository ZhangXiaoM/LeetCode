
/*

https://leetcode.com/problems/linked-list-cycle-ii/description/

Given a linked list, return the node where the cycle begins.
If there is no cycle, return null.

Note: Do not modify the linked list.

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

    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && slow != null) {
            slow = slow.next;
            if (fast.next == null) return null;
            fast = fast.next.next;

            if (slow == fast) break;
        }

        if (fast == null || slow == null) return null;

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
