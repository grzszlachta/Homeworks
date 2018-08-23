package tools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NodeList {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node3;

//        System.out.println("loop = " + hasLoop(node1, node1));
//        System.out.println("loop = " + hasLoopWithReturn(node1, node1));
        System.out.println("loop = " + findStartOfLoop(node1));

        /*List<Node> result = new ArrayList<>();
        printPath(node1, node3, result);
        System.out.println("result = " + result);*/
    }

    public static void printPath(Node currentNode, Node end, Collection<Node> storage) {
        storage.add(currentNode);
        if (currentNode.next != null && end != currentNode) {
            printPath(currentNode.next, end, storage);
        }
    }

    public static Node findStartOfLoop(Node node) {
        Node meatup = hasLoopWithReturn(node, node);
        if (meatup != null) {
            int loopSize = 1;
            Node start = meatup;
            Node finish = meatup.next;
            while (start != finish) {
                finish = finish.next;
                loopSize++;
            }
            System.out.println("loopSize = " + loopSize);
            Node first = node;
            Node second = node;
            while (loopSize > 0) {
                second = second.next;
                loopSize--;
            }
            while (first != second) {
                first = first.next;
                second = second.next;
            }
            return first;
        }
        return null;
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

    public static Node hasLoopWithReturn(Node slow, Node fast) {
        if (slow.next == null || fast.next == null || fast.next.next == null) {
            return null;
        }
        Node result = null;
        if (slow.next == fast.next.next) {
            return slow.next;
        } else {
            result = hasLoopWithReturn(slow.next, fast.next.next);
        }
        return result;
    }
}
