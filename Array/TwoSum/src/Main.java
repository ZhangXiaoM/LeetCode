import java.lang.reflect.Array;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        int[] ints = {3,2,4};
        System.out.println(Main.twoSum(ints, 6));
    }

    public static int[] twoSum(int[] nums, int target) {

        int[] re = {0,0};
        if (nums.length <= 0) return re;
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                if (nums[j] == target - nums[i]) {
                    int[] result = {i,j};
                    return result;
                }
            }
        }

        return re;
    }
}
