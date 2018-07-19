package tools;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class QueueTest {

    @Test
    public void testLinkedList() {
        Deque<String> words = new LinkedList<>();
        words.addFirst("Hello");
        words.addFirst("World");
        words.offerFirst("!");

        for (int i = 0; i < 2; i++) {
            System.out.println(words.peekLast());
            words.removeLast();
            System.out.println("words = " + words);
        }

        System.out.println("__________\nwords = " + words);
    }
}
