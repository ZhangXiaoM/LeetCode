/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        System.out.println(intersection(nums1,nums2));
    }


    public static int[] intersection(int[] nums1, int[] nums2) {


        Set<Integer> set1 = new HashSet();
        Set<Integer> set2 = new HashSet();

        for (int i = 0; i < nums1.length; ++i) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; ++i) {
            if (set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }

        int[] res = set2.stream().mapToInt(i -> i).toArray();

        return res;
    }
}
