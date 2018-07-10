package collections;

public class Storage {

    Node start = null;
    Node finish = null;

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
    }

    public void addNode(Node node) {
        if (start == null) {
            start = node;
            finish = node;
        } else {
            finish.next = node;
            finish = node;
        }
    }
}
