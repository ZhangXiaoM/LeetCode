public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt ++;
            n = n & (n - 1);
        }
        return cnt;
    }
}
