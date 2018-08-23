package tools;

import org.junit.Assert;
import org.junit.Test;

public class JavaStackTest {

    @Test
    public void testBasic() {
        String input = "{}()\n" +
                "({()})\n" +
                "{}(\n" +
                "[]";

        boolean[] expectedResults = new boolean[4];
        int counter = 0;
        for (String s : input.split("\n")) {
            System.out.print(s + " -> ");
            boolean result = JavaStack.isBalanced(s);
            System.out.println(result);
            expectedResults[counter++] = result;
        }
        Assert.assertTrue(expectedResults[0]);
        Assert.assertTrue(expectedResults[1]);
        Assert.assertFalse(expectedResults[2]);
        Assert.assertTrue(expectedResults[3]);
    }
}
