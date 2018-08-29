/**
 *
 * https://leetcode.com/problems/linked-list-components/description/
 *
 * We are given head, the head node of a linked list containing unique integer values.
 *
 * We are also given the list G, a subset of the values in the linked list.
 *
 * Return the number of connected components in G, where two values are connected if they appear consecutively in the linked list.
 *
 * Example 1:
 *
 * Input:
 * head: 0->1->2->3
 * G = [0, 1, 3]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, so [0, 1] and [3] are the two connected components.
 * Example 2:
 *
 * Input:
 * head: 0->1->2->3->4
 * G = [0, 3, 1, 4]
 * Output: 2
 * Explanation:
 * 0 and 1 are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two connected components.
 * Note:
 *
 * If N is the length of the linked list given by head, 1 <= N <= 10000.
 * The value of each node in the linked list will be in the range [0, N - 1].
 * 1 <= G.length <= 10000.
 * G is a subset of all values in the linked list.
 */

package com.zmc;

import java.util.Arrays;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Main {



    public static void main(String[] args) {
	// write your code here
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        int[] G = {0,3,1,4};

        System.out.print(numComponents(head, G));
    }

    public static int numComponents(ListNode head, int[] G) {

        if (head == null) return 0;

        int res = 0;
        ListNode tmp = head;
        Arrays.sort(G);
        int num = 0;

        while (tmp != null) {

            if (Arrays.binarySearch(G, tmp.val) >= 0) {
                if (tmp.next == null) res ++;
                num ++;
            } else {
                if (num != 0) {
                    res ++;
                    num = 0;
                }
            }

            tmp = tmp.next;
        }

        return res;
    }
}
