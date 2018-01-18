import sun.nio.cs.ext.MacArabic;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        System.out.println(nextGreaterElement(1999999999));
    }

    public static int nextGreaterElement(int n) {

        String s = String.valueOf(n);
        char[] nums = s.toCharArray();

        int d = -1;
        for (int i = nums.length - 1; i > 0; --i) {
            if (nums[i - 1] < nums[i]) {
                d = nums[i - 1];
                Arrays.sort(nums,i,nums.length);

                for (int j = i; j < nums.length; ++j) {
                    if (nums[j] > nums[i - 1]) {
                        char temp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
                break;
            }
        }
        if (d == -1) return -1;

        long val = Long.parseLong(new String(nums));

        return (val <= Integer.MAX_VALUE) ? (int)val : -1;
    }

}
