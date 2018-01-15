

public class Main {

    public static void main(String[] args) {

        List list = new List();
        Node temp = list.first;
        list.CreateList(10);
        while (temp.next != null) {

            if (temp.next == temp) {
                temp.next = null;
            } else {
                temp = temp.next.next;
                list.DeleteNode(temp);
                temp = temp.next;
            }
        }

        System.out.println(temp.val);

        System.out.println("Hello World!");
    }

}
