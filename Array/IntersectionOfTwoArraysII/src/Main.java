
/*

https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 0};
        int[] nums2 = {2, 2, 3};

        System.out.println(intersect(nums1,nums2));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {

        if (nums1 == null || nums2 == null) return null;

        List<Integer> list = new ArrayList();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums1.length; ++i) {
            Integer temp = map.get(nums1[i]);
            if (temp == null) temp = 0;
            map.put(nums1[i], ++temp);
        }

        for (int i = 0; i < nums2.length; ++i) {
            Integer temp = map.get(nums2[i]);
            if (temp != null) {
                if (temp > 0) list.add(nums2[i]);
                map.put(nums2[i], --temp);
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}
