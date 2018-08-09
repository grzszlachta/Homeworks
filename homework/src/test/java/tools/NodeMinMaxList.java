package tools;

public class NodeMinMaxList {

    Node tail;
    Node min;
    Node max;

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(20);
        Node node3 = new Node(300);
        Node node4 = new Node(40);

        NodeMinMaxList storage = new NodeMinMaxList();
        storage.addNode(node1);
        storage.addNode(node2);
        storage.addNode(node3);
        storage.addNode(node4);
        System.out.println("storage.min = " + storage.min());
        System.out.println("storage.max = " + storage.max());
    }

    public void addNode(Node node) {
        if (tail == null) {
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        if (min != null) {
            min = min.data < node.data ? min : node;
        } else {
            min = node;
        }
        if (max != null) {
            max = node.data > max.data ? node : max;
        } else {
            max = node;
        }
    }


    public Node min() {
        return min;
    }

    public Node max() {
        return max;
    }
}
