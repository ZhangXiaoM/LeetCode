import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String s = "abcabcabcaccaaaaxaxvxbxnxjxuxixoxpxyxpxlxpx1x3x4";

        System.out.println(maxCharOfString2(s));
    }

    static char maxCharOfString(String s) {

        if (s.length() <= 0) return ' ';

        String temp = "";

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (temp.indexOf(c) <= -1) {
                temp += c;
            }
        }

        int[] a = new int[temp.length()];

        for (int i = 0; i < temp.length(); ++i) {
            for (int j = 0; j < s.length(); ++j) {
                if (s.charAt(j) == temp.charAt(i)) {
                    a[i] ++;
                }
            }
        }

        int max = a[0];
        int index = 0;
        for (int i = 1; i < a.length; ++i) {
            if (max < a[i]) {
                max = a[i];
                index = i;
            }
        }

        return temp.charAt(index);
    }

    static char maxCharOfString2(String s) {
        if (s.length() <= 0) return ' ';

        HashMap<String, Integer> map = new HashMap();
        int t = 0;
        for (char c: s.toCharArray()) {
            map.put(Character.toString(c), 0);
        }

        for (char c: s.toCharArray()) {
            Integer x = map.get(Character.toString(c));
//            x++;
            map.put(Character.toString(c), ++x);
        }

        int max = 0;
        String temp = "";
        for (String key : map.keySet()) {
            Integer x = map.get(key);
            if (max < x) {
                max = x;
                temp = key;
            }
        }

        return temp.charAt(0);
    }

    static char maxCharOfString3(String s) {
        if (s.length() <= 0) return ' ';

        int[] a = new int[255];

        for (char c : s.toCharArray()) {
            a[c] ++;
        }

        int max = 0;
        char c = 0;

        for (char i = 0; i < a.length; ++i) {
            if (a[i] == 0) continue;
            if (max < a[i]) {
                max  = a[i];
                c = i;
            }
        }

        return c;
    }
}
