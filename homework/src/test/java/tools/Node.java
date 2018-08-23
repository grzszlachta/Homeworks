package tools;

public class Node {
    int data;
    public Node next;

    public Node(int value) {
        data = value;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}
