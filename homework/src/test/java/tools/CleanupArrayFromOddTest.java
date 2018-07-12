package tools;

import org.junit.Assert;
import org.junit.Test;

public class CleanupArrayFromOddTest {

    private static int[] cleanupArray(int[] input) {
        return input;
    }

    @Test
    public void testCleanupOdd() {
        int[] input = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expectedArray = {0, 2, 4, 6, 8};
        Assert.assertArrayEquals(expectedArray, cleanupArray(input));
    }

    @Test
    public void testCleanupOddExpectedEmpty() {
        int[] input = {1, 1, 1, 1, 1};
        int[] expectedArray = {};
        Assert.assertArrayEquals(expectedArray, cleanupArray(input));
    }

    @Test
    public void testCleanupOddEmpty() {
        int[] input = {};
        Assert.assertArrayEquals(input, cleanupArray(input));
    }

    @Test
    public void testCleanupOddFull() {
        int[] input = {2, 4, 6, 8, 100};
        Assert.assertArrayEquals(input, cleanupArray(input));
    }

}
