package tools;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class ListTest {

    @Test
    public void testMultiplyList() {
        String[] words = "Imagine all the people living life in peace, you".split(" ");
        List<String> listWords = new ArrayList<>(Arrays.asList(words));
        List<String> expected = Arrays.asList("Imagine", "Imagine", "all", "all", "the", "the", "people", "people", "" +
                "living", "living", "life", "life", "in", "in", "peace,", "peace,", "you", "you");
        Assert.assertArrayEquals(expected.toArray(), multiply(listWords, 2).toArray());

    }

    private List<String> multiply(List<String> listWords, int multiplier) {
        List<String> result = new ArrayList<>();
        for (String word : listWords) {
            for (int i = 0; i<multiplier; i++) {
                result.add(word);
            }
        }
        return result;
    }

    @Test
    public void testSplitToList() {
        List<String> input = Arrays.asList("Imagine", "Imagine", "all", "all", "the", "the", "people", "people", "" +
                "living", "living", "life", "life", "in", "in", "peace,", "peace,", "you", "you");
        List<String> expected = Arrays.asList("Imagine", "all", "the", "people", "living", "life", "in", "peace,", "you");
        Assert.assertArrayEquals(expected.toArray(), cleanup(input).toArray());
    }

    private List<String> cleanup(List<String> input) {
        List<String> result = new ArrayList<>();
        for (String word : input) {
            if (!result.contains(word)) {
                result.add(word);
            }
        }
        return result;
    }

    @Test
    public void testDeleteFromList() {
        List<String> listWords = Arrays.asList("Imagine all the people living life in peace, you".split(" "));
        List<String> workingIteratorList = new ArrayList<>(listWords);
        Iterator<String> iterator = workingIteratorList.iterator();
        int counter = 0;
        while (iterator.hasNext()) {
            iterator.next();
            if (counter % 2 != 0) {
                iterator.remove();
            }
            counter++;
        }
        List<String> expected = Arrays.asList("Imagine", "the", "living", "in", "you");
        Assert.assertEquals(expected, workingIteratorList);
    }
}
