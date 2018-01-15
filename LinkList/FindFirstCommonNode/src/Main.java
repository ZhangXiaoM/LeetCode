public class Main {

    private class Node {
        int val;
        Node next;
    }

    public static void main(String[] args) {


        System.out.println("Hello World!");
    }

    static Node findFirstNode(Node first1, Node first2) {

        if (first1 == null || first2 == null) {
            return null;
        }

        Node temp1 = first1;
        Node temp2 = first2;

        int len1 = getLength(temp1);
        int len2 = getLength(temp2);

        Node longNode = first1;
        Node shortNode = first2;
        int longLen = len1;
        int shortLen = len2;

        if (len1 < len2) {
            longNode = first2;
            shortNode = first1;

            longLen = len2;
            shortLen = len1;
        }

        int diff = longLen - shortLen;

        for (int i = 0; i < diff; ++i) {
            longNode = longNode.next;
        }

        while (longNode != null && shortNode != null && longNode != shortNode) {
            longNode = longNode.next;
            shortNode = shortNode.next;
        }

        return longNode;
    }

    static int getLength(Node first) {
        Node temp = first;
        int cnt = 0;
        while (temp.next != null) {
            cnt ++;
            temp = temp.next;
        }
        return cnt;
    }
}
