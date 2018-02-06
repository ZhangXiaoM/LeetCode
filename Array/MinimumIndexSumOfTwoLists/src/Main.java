
/*

https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/

Suppose Andy and Doris want to choose a restaurant for dinner,
and they both have a list of favorite restaurants represented by strings.

You need to help them find out their common interest with the least list index sum.
If there is a choice tie between answers, output all of them with no order requirement.
You could assume there always exists an answer.

Example 1:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
Output: ["Shogun"]
Explanation: The only restaurant they both like is "Shogun".

Example 2:
Input:
["Shogun", "Tapioca Express", "Burger King", "KFC"]
["KFC", "Shogun", "Burger King"]
Output: ["Shogun"]
Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).

Note:
The length of both lists will be in the range of [1, 1000].
The length of strings in both lists will be in the range of [1, 30].
The index is starting from 0 to the list length minus 1.
No duplicates in both lists.

 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = {"KFC","Burger King","Tapioca Express","Shogun"};

        System.out.println(findRestaurant(list1, list2));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; ++i) {
            map.put(list1[i], i);
        }

        int min = list1.length + list2.length;
        for (int i = 0; i < list2.length; ++i) {
            Integer temp = map.get(list2[i]);
            if (temp != null) {
                if (min > temp + i) {
                    min = temp + i;
                    if (res.size() > 0) {
                        res.clear();
                        res.add(list2[i]);
                    } else {
                        res.add(list2[i]);
                    }
                } else if (min == temp + i) {
                    res.add(list2[i]);
                }
            }
        }

        String ress[] = res.toArray(new String[res.size()]);
        return  ress;
    }
}
