public class Main {

    public static void main(String[] args) {

        System.out.println(reverseBits(1));
    }

    public static int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; ++ i) {
            res = res << 1;
            if ((n & 1) == 1) res ++;
            n = n >> 1;
        }

        return res;
    }
}
