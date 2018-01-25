
/*

https://leetcode.com/problems/merge-intervals/description/

Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].

*/


import java.util.ArrayList;
import java.util.List;

public class Main {

    static public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }


    public static List<Interval> merge(List<Interval> intervals) {

        List<Interval> list = new ArrayList();

        if (intervals == null) return null;
        if (intervals.size() == 0) return list;

        // make the list of intervals order
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); ++i) {
            int tempEnd = intervals.get(i).end;
            int tempStart = intervals.get(i).start;

            if (end < tempStart) {
                list.add(new Interval(start, end));
                start = tempStart;
                end = tempEnd;
            } else {
                end = Math.max(end, tempEnd);
            }
        }
        list.add(new Interval(start, end));

        return list;
    }
}
