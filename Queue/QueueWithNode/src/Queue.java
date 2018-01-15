public class Queue {

    private class Node {
        String item;
        Node next;
    }

    private Node first;
    private Node last;
    private int cnt = 0;

    public boolean isEmpty() {
        return cnt == 0;
    }

    public void enqueue(String s) {
        Node node = new Node();
        node.item = s;
        if (last == null) {
            first = node;
            last = node;
        } else {
            last.next = node;
            last = node;
        }

        cnt ++;
    }

    public String dequeue() {
        String item = first.item;
        first = first.next;
        cnt --;
        return item;
    }
}
