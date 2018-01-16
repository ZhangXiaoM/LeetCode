public class Main {

    public static void main(String[] args) {

        String m = countAndSay(3);
        System.out.println(m);
    }

    static String countAndSay(int n) {
        if (n == 1) return "1";

        String s = countAndSay(n - 1);

        int cnt = 1;

        String result = "";
        char[] chars = s.toCharArray();

        for (int i = 1; i < chars.length; ++i) {

            if (chars[i] == chars[i - 1]) {
                cnt ++;
            } else {
                result += String.valueOf(cnt);
                result += chars[i - 1];
                cnt = 1;
            }
        }
        result += String.valueOf(cnt);
        result += chars[chars.length - 1];

        return result;
    }
}
