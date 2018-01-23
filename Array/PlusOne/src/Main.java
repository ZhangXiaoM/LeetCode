public class Main {

    public static void main(String[] args) {
        int[] dig = {9};
        System.out.println(plusOne(dig));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                digits[i] ++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] res = new int[digits.length + 1];
        digits[0] = 1;
        return res;
    }
}
