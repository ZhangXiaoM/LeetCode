import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        System.out.println(isValid("){"));
    }

    public static boolean isValid(String s) {

        if (s.length() <= 1) return false;

        Stack<Character> stack = new Stack<Character>();

        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (!stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
