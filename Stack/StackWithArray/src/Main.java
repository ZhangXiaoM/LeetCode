import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack stack = new Stack(2);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if (s.equals("-")) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.pop());
                } else {
                    System.out.println("Stack is empty!");
                    break;
                }
            } else {
                stack.push(s);
            }
        }
    }
}
