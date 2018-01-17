/*
Given a list of sorted characters letters containing only lowercase letters,
and given a target letter target, find the smallest element in the list that
is larger than the given target.

Letters also wrap around. For example,
if the target is target = 'z' and letters = ['a', 'b'],
the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:
letters has a length in range [2, 10000].
letters consists of lowercase letters, and contains at least 2 unique letters.
target is a lowercase letter.
 */
public class Main {

    public static void main(String[] args) {
        char[] cs = {'c','f','j'};
        System.out.println(nextGreatestLetter2(cs, 'k'));
    }

    // time:O(N) space:O(N)
    public static char nextGreatestLetter(char[] letters, char target) {

        if (target < letters[0]) return letters[0];
        if (target >= letters[letters.length - 1]) return letters[0];
        int[] a = new int[255];
        for (char c : letters) {
            a[c] ++;
        }

        for (int i = target + 1; i < a.length; i ++) {
            if (a[i] > 0) {
                return (char)i;
            }
        }

        return 0;
    }

    // binary search O(lgN)
    public static char nextGreatestLetter2(char[] letters, char target) {

        int low = 0;
        int high = letters.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (target < letters[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return letters[low % letters.length];
    }
}
