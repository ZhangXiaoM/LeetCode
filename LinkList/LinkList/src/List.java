public class List {

    public Node first = new Node();

    void CreateList(int cnt) {

        first.val = 1;
        Node temp = first;
        for (int i = 2; i <= cnt; ++ i) {
            Node node = new Node();
            node.val = i;
            temp.next = node;
            temp = node;
        }
        temp.next = first;
    }

    public void DeleteNode(Node node) {
        Node temp = this.first;

        while (temp.next != node) {
            temp = temp.next;
        }

        temp.next = node.next;
    }
}
