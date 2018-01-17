import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        System.out.println(nextGreaterElement(nums1,nums2));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] a = new int[nums1.length];
        for (int i = 0; i < a.length; ++ i) {
            a[i] = -1;
        }

        for (int i = 0; i < nums1.length; ++i) {
            for (int j = nums2.length - 1; j >= 0; --j) {
                if (nums2[j] > nums1[i]) a[i] = nums2[j];
                if (nums2[j] == nums1[i]) break;
            }
        }
        return a;
    }
}
