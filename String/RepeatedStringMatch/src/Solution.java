
public class Solution {

    public int repeatedStringMatch(String A, String B) {

        int repeatedCount = 1;

        String temp = A;

        while (!temp.contains(B)) {

            if (temp.length() - A.length() > B.length()) return -1;

            temp += A;
            repeatedCount ++;
        }

        return repeatedCount;
    }
}
