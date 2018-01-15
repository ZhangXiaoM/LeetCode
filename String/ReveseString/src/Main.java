
import java.util.Scanner;
import java.util.Stack;
public class Main {

    public static void main(String[] args) {

        Reverse rev = new Reverse();
        rev.reverseCharacter();
    }
}

class Reverse {
    public void reverseString() {
        Stack st = new Stack();

        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();

        String[] a = in.split(" ");

        for (String s: a) {
            st.push(s);
        }
        String  out = "";
        while (!st.isEmpty()) {
            out += st.pop() + " ";
        }
        System.out.println(out);
    }

    public void reverseCharacter() {
        Stack st = new Stack();

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        for (char a: s.toCharArray()) {
            st.push(a);
        }
        String  out = "";
        while (!st.isEmpty()) {
            out += st.pop();
        }
        System.out.println(out);
    }
}


