public class Main {

    public static void main(String[] args) {

        char[] cs = "aabbccc".toCharArray();

        System.out.println(compress(cs));
    }

    public static int compress(char[] chars) {
        if (chars.length == 1) return 1;

        String s = "";
        int cnt = 1;

        for (int i = 1; i < chars.length; ++i) {
            if (chars[i] == chars[i - 1]) {
                cnt ++;
            } else {
                s += chars[i - 1];
                if (cnt > 1) {
                    s += Integer.toString(cnt);
                }
                cnt = 1;
            }
        }

        s += chars[chars.length - 1];
        s += Integer.toString(cnt);

        for (int i = 0; i < s.length(); ++i) {
            chars[i] = s.charAt(i);
        }

        return s.length();
    }
}
