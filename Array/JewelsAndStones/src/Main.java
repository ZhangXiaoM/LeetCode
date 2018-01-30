public class Main {

    public static void main(String[] args) {
        String J = "aA", S = "aAAbbbb";
        System.out.println(numJewelsInStones(J, S));
    }

    public static int numJewelsInStones(String J, String S) {
        if (J == null || J.length() == 0) return 0;

        int res = 0;

        int[] help = new int[256];
        for (char c : J.toCharArray()) {
            help[c] ++;
        }

        for (char c : S.toCharArray()) {
            if (help[c] != 0) {
                res ++;
            }
        }

        return res;
    }
}
