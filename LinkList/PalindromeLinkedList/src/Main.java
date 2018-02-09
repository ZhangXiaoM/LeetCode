
/*

https://leetcode.com/problems/palindrome-linked-list/description/

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

 */


public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static boolean isPalindrome(ListNode head) {

        if (head == null) return true;

        ListNode s = head, f = head;

        while (f != null && f.next != null) {
            s = s.next;
            f = f.next.next;
        }

        if (f != null) {
            s = s.next;
        }

        s = reverseList(s);
        f = head;

        while (s != null) {
            if (s.val != f.val) return false;
            s = s.next;
            f = f.next;
        }

        return true;
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
