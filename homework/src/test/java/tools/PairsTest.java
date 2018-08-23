package tools;

import org.junit.Assert;
import org.junit.Test;

public class PairsTest {

    @Test
    public void testSimple() {
        int[] input = {1, 5, 3, 4 ,2};
        int delta = 2;
        int expectedOutput = 3;
        Assert.assertEquals(expectedOutput, Pairs.pairs(delta, input));
    }

    @Test
    public void testBasic() {
        int[] input = {363374326, 364147530, 61825163, 1073065718, 1281246024, 1399469912, 428047635, 491595254, 879792181, 1069262793};
        int delta = 1;
        int expectedOutput = 0;
        Assert.assertEquals(expectedOutput, Pairs.pairs(delta, input));
    }

    @Test
    public void testAgain() {
        int[] input = {1, 3, 5, 8, 6, 4, 2};
        int delta = 2;
        int expectedOutput = 5;
        Assert.assertEquals(expectedOutput, Pairs.pairs(delta, input));
    }
}
