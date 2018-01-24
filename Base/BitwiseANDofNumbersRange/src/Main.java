public class Main {

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(6, 7));
    }

    // time complexity O(lgN)

    public static int rangeBitwiseAnd(int m, int n) {

        int res = m;
        int bit = 1;
        while (m != n) {
            if ((res & bit) != 0) res &= (res - 1);
            bit <<= 1;
            m >>= 1;
            n >>= 1;
        }

        return res;
    }

    // time complexity O(N)

    public static int rangeBitwiseAnd2(int m, int n) {

        int temp = m;
        int cnt = 0;
        while (temp != 0) {
            cnt ++;
            temp >>= 1;
        }

        int res = (int)(Math.pow(2,cnt) - 1);

        for (int i = m; i <= n; ++i) {
            res &= i;
        }

        return res;
    }


}
