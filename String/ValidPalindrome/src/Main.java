/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
 */

public class Main {

    public static void main(String[] args) {

        String s = "a.b,.";
        System.out.println(isPalindrome(s));
    }

    static boolean isPalindrome(String s) {
        if (s == null) return false;

        // time out way

//        String lowTemp = s.toLowerCase();
//        String temp = "";
//        for (int i = 0; i < lowTemp.length(); ++i) {
//            char ic = lowTemp.charAt(i);
//            if ((ic >= 'a' && ic <= 'z') || (ic >= '0' && ic <= '9')) {
//                temp += String.valueOf(ic);
//            }
//        }

//        for (int i = 0; i < temp.length(); ++i) {
//            if (temp.charAt(i) != temp.charAt(temp.length() - 1 - i)) return false;
//        }
//        return true;

        int i = 0, j = s.length() - 1;
        while (i < j) {
            char ic = s.charAt(i);
            char jc = s.charAt(j);
            if (!isAlphanumeric(ic)) {
                i++;
            } else if (!isAlphanumeric(jc)) {
                j--;
            } else {
                if (Character.toLowerCase(ic) != Character.toLowerCase(jc))
                    return false;

                i++;
                j--;
            }
        }

        return true;
    }

    static boolean isAlphanumeric(char c) {
        return ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z'));
    }
}

