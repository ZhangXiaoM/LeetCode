
/*
Given two non-negative integers num1 and num2 represented as string,
return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

public class Main {

    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "9";
        System.out.println(addStrings(num1, num2));
    }

    public static String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) return num2;
        if (num2 == null || num2.length() == 0) return num1;

        int carry = 0;
        String res = "";

        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; i --, j --) {
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
