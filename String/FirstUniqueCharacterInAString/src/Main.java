public class Main {

    public static void main(String[] args) {


        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {
        if (s.length() <= 0) return -1;

        int[] a = new int[255];

        for (char c: s.toCharArray()) {
            a[c] ++;
        }

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (a[c] == 1) {
                return i;
            }
        }

        return -1;
    }
}
