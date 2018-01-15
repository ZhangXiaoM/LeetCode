
public class Main {

    public static void main(String[] args) {
        String aS = "1";
        String bS = "11";

        System.out.println(addBinary(aS,bS));
    }

    public static String addBinary(String a, String b) {

        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;

        StringBuilder sb = new StringBuilder();
        int carry = 0;

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {

            char m = i >= 0? a.charAt(i) : '0';
            char n = j >= 0? b.charAt(j) : '0';

            int an = m - '0';
            int bn = n - '0';

            int cn = an + bn + carry;
            sb.append(cn % 2);

            carry = cn / 2;
        }

        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
