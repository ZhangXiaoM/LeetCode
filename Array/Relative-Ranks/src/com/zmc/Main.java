package com.zmc;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] aa = {5, 3, 2, 4, 1};
        System.out.print(findRelativeRanks(aa));
    }

    public static String[] findRelativeRanks(int[] nums) {
        if (nums == null || nums.length == 0) return new String[0];
        String[] res = new String[nums.length];

        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int max = Integer.MIN_VALUE;
            int idx = 0;
            for (int j = 0; j < nums.length; ++j) {
                if (map.keySet().contains(j)) continue;
                if (max < nums[j]) {
                    idx = j;
                    max = nums[j];
                }
            }

            String val;
            if (i == 0) val = "Gold Medal";
            else if (i == 1) val = "Silver Medal";
            else if (i == 2) val = "Bronze Medal";
            else val = String.valueOf(i + 1);
            map.put(idx, val);
        }

        for (int i: map.keySet()) {
            res[i] = map.get(i);
        }
        return res;
    }
}
