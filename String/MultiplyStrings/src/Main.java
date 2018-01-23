
/*
Given two non-negative integers num1 and num2 represented as strings,
return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String num1 = "191";
        String num2 = "0";

        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {

        if (num1 == null || num1.length() == 0) return num2;
        if (num2 == null || num2.length() == 0) return num1;

        if (num1.equals("0") || num2.equals("0")) return "0";

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = num1.length() - 1; i >= 0; --i) {
            StringBuffer sb = new StringBuffer();
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; --j) {

                int in = num1.charAt(i) - '0';
                int jn = num2.charAt(j) - '0';

                int temp = in * jn + carry;
                sb.append(String.valueOf(temp % 10));
                carry = temp / 10;
            }

            if (carry != 0) {
                sb.append(String.valueOf(carry));
            }

            for (int k = 0; k < num1.length() - 1 - i; k ++) {
                sb.insert(0, "0");
            }
            arrayList.add(sb.reverse().toString());
        }

        String res = "";
        for (int i = 0; i < arrayList.size(); ++i) {
            res = add(res, arrayList.get(i));
        }

        return res;
    }

    public static String add(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num2;
        if (num2 == null || num2.length() == 0) return num1;

        int carry = 0;
        String res = "";
        int i = num1.length() - 1, j = num2.length() - 1;
        for(;i >= 0 || j >= 0 || carry != 0; i --, j --) {
            char ic = '0', jc = '0';
            if (i >= 0) ic = num1.charAt(i);
            if (j >= 0) jc = num2.charAt(j);

            int in = ic - '0';
            int jn = jc - '0';

            String temp = String.valueOf((in + jn + carry ) % 10);
            res += temp;

            carry = (in + jn + carry) / 10;
        }

        return new StringBuffer(res).reverse().toString();
    }

}
