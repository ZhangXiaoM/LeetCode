import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue queue = new Queue();

        while (sc.hasNextLine()) {
            String s = sc.nextLine();

            if (s.equals("-")) {
                if (!queue.isEmpty()) {
                    System.out.println(queue.dequeue());
                } else {
                    System.out.println("Queue is empty!");
                    break;
                }
            } else {
                queue.enqueue(s);
            }
        }
    }
}
