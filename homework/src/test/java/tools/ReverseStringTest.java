package tools;

import org.junit.Assert;
import org.junit.Test;

public class ReverseStringTest {

    @Test
    public void testEmpty() {
        String input = "";
        Assert.assertEquals(input, ReverseString.reverse(input));
    }

    @Test
    public void testAbcd() {
        String input = "abcd";
        Assert.assertEquals("dcba", ReverseString.reverse(input));
    }

    @Test
    public void testAbcdTransfer() {
        String input = "abcd";
        Assert.assertEquals(input, ReverseString.reverse(ReverseString.reverse(input)));
    }

}
