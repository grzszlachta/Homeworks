package tools;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SetTest {

    @Test
    public void testUnique() {
        Set<String> input = new HashSet<>();
        for (int i = 0; i < 13; i++) {
            input.add("A");
            input.add("B");
        }
        System.out.println("input = " + input);
    }

    @Test
    public void testRemoveDuplicationFromList() {
        List<String> input = Arrays.asList("Imagine", "Imagine", "all", "all", "the", "the", "people", "people", "" +
                "living", "living", "life", "life", "in", "in", "peace,", "peace,", "you", "you");
        List<String> expected = Arrays.asList("all", "living", "in", "peace,", "people", "life", "the", "Imagine", "you");
        // put elements of input to set result
        Set<String> result = new HashSet<>();

        Assert.assertEquals(expected.size(), result.size());
        for (String expect : expected) {
            Assert.assertTrue(result.contains(expect));
        }
        for (String resulted : result) {
            Assert.assertTrue(expected.contains(resulted));
        }
    }

    @Test
    public void testOrderedSet() {
        List<String> input = Arrays.asList("all", "living", "in", "peace,", "people", "life", "the", "Imagine", "you");
        // put input collection to result set in natural order
        Set<String> result = null;
        Collections.sort(input);
        Assert.assertArrayEquals(input.toArray(), result.toArray());
    }

    @Test
    public void testReverseOrderedSet() {
        List<String> input = Arrays.asList("all", "living", "in", "peace,", "people", "life", "the", "Imagine", "you");
        // put input collection to result set in reverse natural order
        Set<String> result = new TreeSet<>();
        input.sort(Collections.reverseOrder());
        Assert.assertArrayEquals(input.toArray(), result.toArray());
    }


}
