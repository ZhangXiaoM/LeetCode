import java.util.Scanner;

public class Main {

    public static void main (String[] args) {

        Stack stack = new Stack();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.equals("-")) {
                System.out.println(stack.pop());
            } else {
                stack.push(s);
            }
        }
    }
}
