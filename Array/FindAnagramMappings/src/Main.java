/*
Given two lists A and B, and B is an anagram of A.
B is an anagram of A means B is made by randomizing the order of the elements in A.

We want to find an index mapping P,
from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.

These lists A and B may contain duplicates. If there are multiple answers, output any of them.

For example, given

A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]
We should return
[1, 4, 3, 2, 0]
as P[0] = 1 because the 0th element of A appears at B[1],
and P[1] = 4 because the 1st element of A appears at B[4], and so on.

Note:

A, B have equal lengths in range [1, 100].
A[i], B[i] are integers in range [0, 10^5].
 */

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        int[] A = {12, 28, 46, 32, 50};
        int[] B = {50, 12, 32, 46, 28};

        System.out.println(anagramMappings1(A, B));
    }

    // time complexity O(N^2)
    public static int[] anagramMappings(int[] A, int[] B) {

        int[] res = new int[A.length];

        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < B.length; ++j) {
                if (B[j] == A[i]) {
                    res[i] = j;
                    break;
                }
            }
        }

        return res;
    }

    // time complexity O(N), space complexity O(N)
    public static int[] anagramMappings1(int[] A, int[] B) {

        int[] res = new int[A.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; ++i) {
            map.put(B[i], i);
        }

        for (int i = 0; i < B.length; ++i) {
            res[i] = map.get(A[i]);
        }

        return res;
    }
}
