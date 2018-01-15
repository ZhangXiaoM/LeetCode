public class Stack {

    Node first = null;
    int cnt = 0;

    public boolean isEmpty () {
        return cnt == 0;
    }

    public void push(String str) {
        Node node = new Node();
        node.item = str;
        node.next = first;
        first = node;

        cnt ++;
    }

    public String pop() {
        String item = first.item;
        first = first.next;

        cnt --;
        return item;
    }
}
