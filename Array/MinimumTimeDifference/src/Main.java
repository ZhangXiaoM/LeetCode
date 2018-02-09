/*

https://leetcode.com/problems/minimum-time-difference/description/

Given a list of 24-hour clock time points in "Hour:Minutes" format,
find the minimum minutes difference between any two time points in the list.

Example 1:
Input: ["23:59","00:00"]
Output: 1

Note:
The number of time points in the given list is at least 2 and won't exceed 20000.
The input time is legal and ranges from 00:00 to 23:59.
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] ss = {"10:32","14:55","13:03","15:52","15:05"};
        List<String> list = Arrays.asList(ss);

        System.out.println(findMinDifference(list));
    }

    // time complexity O(N*lgN) space complexity O(1)

    public static int findMinDifference(List<String> timePoints) {

        int min = Integer.MAX_VALUE;

        Collections.sort(timePoints, new Comparator<String>(){
            public int compare(String s1, String s2) {
                Integer i1 = Integer.parseInt(s1.substring(0,2) + s1.substring(3, 5));
                Integer i2 = Integer.parseInt(s2.substring(0,2) + s2.substring(3, 5));
                return i1.compareTo(i2);
            }
        });

        for (int i = 1; i < timePoints.size(); ++i) {
            int minus = minusOfTwoTimePoint(timePoints.get(i), timePoints.get(i - 1));
            min = Math.min(min, minus);
        }

        // the minus between the first and the last
        int last = minusOfTwoTimePoint(timePoints.get(0), timePoints.get(timePoints.size() - 1));

        return Math.min(last, min);
    }

     static int minusOfTwoTimePoint(String time1, String time2) {

        int res = 0;

        if (time1.equals(time2)) return res;

        int hour1 = Integer.valueOf(time1.substring(0, 2));
        int hour2 = Integer.valueOf(time2.substring(0, 2));

        int mins1 = Integer.valueOf(time1.substring(3, 5));
        int mins2 = Integer.valueOf(time2.substring(3, 5));

        res = Math.abs(hour1 - hour2) * 60;
        if (res == 0)
            res = Math.abs(mins1 - mins2);
        else res += hour1 > hour2? (mins1 - mins2) : (mins2 - mins1);

        return Math.min(res, 1440 - res);
    }
}
