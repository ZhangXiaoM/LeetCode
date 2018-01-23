public class Main {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1,4));
    }

    public static int hammingDistance(int x, int y) {

        int distance = 0;
        int temp = x ^ y;

        while (temp != 0) {
            distance ++;
            temp = temp & (temp - 1);
        }

        return distance;
    }
}
