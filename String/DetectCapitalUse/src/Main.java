public class Main {

    public static void main(String[] args) {

        System.out.println(detectCapitalUse("ggg"));
    }


    public static boolean detectCapitalUse(String word) {

        if (word.length() == 1) return true;

        boolean result = true;

        char[] chars = word.toCharArray();

        if (isCapital(chars[0])) {

            if (isCapital(chars[1])) {
                for (int i = 1; i < chars.length; ++i) {
                    result = result && isCapital(chars[i]);
                }
            } else {
                for (int i = 1; i < chars.length; ++i) {
                    result = result && isLow(chars[i]);
                }
            }

        } else {

            for (int i = 1; i < chars.length; ++i) {
                result = result && isLow(chars[i]);
            }
        }

        return result;
    }

    public static boolean isCapital(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public static boolean isLow(char c) {
        return c >= 'a' && c <= 'z';
    }
}
