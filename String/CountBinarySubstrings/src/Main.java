public class Main {

    public static void main(String[] args) {

        System.out.println(countBinarySubstrings("1100"));
    }


    static int countBinarySubstrings(String s) {
        if (s == null || s.length() <= 0) return 0;
        /* 当前后两个字符不同的时候，作为标志
           例如 00111，preValueCount 遍历的第一个1的时候，此时s[i] != s[i - 1]
           preValueCount表示前面一段连续0的个数
           curValueCount表示当前一段连续1的个数
           当他们不相等的时候，肯定有一个满足条件的子串，01和10
           遍历到第二个1的时候，curValueCount=2，preValueCount也是2
           所以 preValueCount == curValueCount 也有一个满足条件的子串
           当遍历到第三个1的时候，连续0的个数小于连续1的个数，所以就不满足条件
        */
        int preValueCount = 0;
        int curValueCount = 1;
        int res = 0;

        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(i - 1)) curValueCount++;
            else {
                preValueCount = curValueCount;
                curValueCount = 1;
            }

            if (preValueCount >= curValueCount) res++;
        }

        return res;
    }
}
