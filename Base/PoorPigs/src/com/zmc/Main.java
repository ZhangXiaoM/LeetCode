
/*

https://leetcode.com/problems/poor-pigs/description/

There are 1000 buckets, one and only one of them contains poison,
the rest are filled with water. They all look the same. If a pig drinks that poison it will die within 15 minutes.
What is the minimum amount of pigs you need to figure out which bucket contains the poison within one hour.

Answer this question, and write an algorithm for the follow-up general case.

Follow-up:

If there are n buckets and a pig drinking poison will die within m minutes,
how many pigs (x) you need to figure out the "poison" bucket within p minutes? There is exact one bucket with poison.


An ambiguous problem!!

The explanation:

With 2 pigs, poison killing in 15 minutes, and having 60 minutes, we can find the poison in up to 25 buckets in the following way. Arrange the buckets in a 5×5 square:

 1  2  3  4  5
 6  7  8  9 10
11 12 13 14 15
16 17 18 19 20
21 22 23 24 25
Now use one pig to find the row (make it drink from buckets 1, 2, 3, 4, 5, wait 15 minutes, make it drink from buckets 6, 7, 8, 9, 10, wait 15 minutes, etc).
Use the second pig to find the column (make it drink 1, 6, 11, 16, 21, then 2, 7, 12, 17, 22, etc).

Having 60 minutes and tests taking 15 minutes means we can run four tests.
If the row pig dies in the third test, the poison is in the third row. If the column pig doesn’t die at all,
the poison is in the fifth column (this is why we can cover five rows/columns even though we can only run four tests).

With 3 pigs, we can similarly use a 5×5×5 cube instead of a 5×5 square and again use one pig to determine the coordinate of one dimension
(one pig drinks layers from top to bottom, one drinks layers from left to right, one drinks layers from front to back).
So 3 pigs can solve up to 125 buckets.

In general, we can solve up to (⌊minutesToTest / minutesToDie⌋ + 1)pigs buckets this way,
so just find the smallest sufficient number of pigs.

from: https://leetcode.com/problems/poor-pigs/discuss/94266/Another-explanation-and-solution

 */


package com.zmc;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.print(poorPigs(25, 15, 60));
    }

    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {

        int pigs = 0;

        int maxBuckets = 1, times = minutesToTest / minutesToDie + 1;
        while (maxBuckets < buckets) {
            maxBuckets *=  times;
            pigs ++;
        }

        return pigs;
    }
}
