
/*

https://leetcode.com/problems/remove-linked-list-elements/description/

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 */


public class Main {

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    /* Note:
     * target is head and head and head and ...
     * target is tail
     * not only one target
     */

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) return null;

        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) return null;

        ListNode pre = head, target = head.next;

        while (target != null) {

            if (target.val == val) {
                if (target.next != null)
                    pre.next = target.next;
                else pre.next = null;
            } else {
                pre = target;
            }

            target = target.next;
        }

        return head;
    }
}
