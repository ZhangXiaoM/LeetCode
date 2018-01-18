public class Main {

    public static void main(String[] args) {

        int[] a = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(dailyTemperatures(a));
    }

    public static int[] dailyTemperatures(int[] temperatures) {

        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; ++i) {
            for (int j = i; j < temperatures.length; ++j) {
                if (temperatures[j] > temperatures[i]) {
                    res[i] = j - i;
                    break;
                }
            }
        }

        return res;
    }
}
