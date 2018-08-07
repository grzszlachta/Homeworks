package tools;

public class NodeList {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node2;

        System.out.println("loop = " + hasLoop(node1, node1));
    }

    public static boolean hasLoop(Node slow, Node fast) {
        if (slow.next == null || fast.next == null || fast.next.next == null) {
            return false;
        }
        boolean result = false;
        if (slow.next == fast.next.next) {
            return true;
        } else {
            result = hasLoop(slow.next, fast.next.next);
        }
        return result;
    }
}
