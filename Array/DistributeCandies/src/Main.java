
/*

https://leetcode.com/problems/distribute-candies/description/

Given an integer array with even length, where different numbers in this array represent different kinds of candies.
Each number means one candy of the corresponding kind. You need to distribute these candies equally in number to brother and sister.
Return the maximum number of kinds of candies the sister could gain.
Example 1:
Input: candies = [1,1,2,2,3,3]
Output: 3
Explanation:
There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
The sister has three different kinds of candies.
Example 2:
Input: candies = [1,1,2,3]
Output: 2
Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
The sister has two different kinds of candies, the brother has only one kind of candies.
Note:

The length of the given array is in range [2, 10,000], and will be even.
The number in given array is in range [-100,000, 100,000].

给姐姐哥哥分糖果，数组中的数字代表糖果的种类，数组的大小代表糖果的数量，姐姐和哥哥分到的糖果的数量必须
相等，另外，数组的大小为偶数，求姐姐能分到的糖果中最多的种类数。

 */

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        int[] is = {1,1,2,3};
        System.out.println(distributeCandies(is));
    }

    // time complexity O(N) space complexity O(N) by using Set

    public static int distributeCandies(int[] candies) {
        if (candies == null || candies.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < candies.length; ++i) {
            set.add(candies[i]);
        }

        int res = set.size();

        return res >= candies.length / 2? candies.length / 2 : res;
    }
}
