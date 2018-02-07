
/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

 */


public class Main {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    // time complexity O(N) space complexity O(1)
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode tempA = headA, tempB = headB;
        int nA = 0, nB = 0;
        while (tempA != null) {
            nA ++;
            tempA = tempA.next;
        }

        while (tempB != null) {
            nB ++;
            tempB = tempB.next;
        }

        int k = Math.abs(nA - nB);

        ListNode listA = headA, listB = headB;

        for (int i = 0; i < k; ++i) {
            if (nA > nB) {
                listA = listA.next;
            } else {
                listB = listB.next;
            }
        }

        for (int i = 0; i < Math.min(nA, nB); ++i) {
            if (listA == listB) {
                return listA;
            } else {
                listA = listA.next;
                listB = listB.next;
            }
        }

        return null;
    }
}
