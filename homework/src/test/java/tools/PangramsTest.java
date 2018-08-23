package tools;

import org.junit.Assert;
import org.junit.Test;

public class PangramsTest {

    @Test
    public void testPangram() {
        checkIsPangram("We promptly judged antique ivory buckles for the next prize", Pangrams.PANGRAM);
        checkIsPangram("We promptly judged antique ivory buckles for the prize", Pangrams.NOT_PANGRAM);
    }

    private void checkIsPangram(String input, String expectedResult) {
        String result = Pangrams.pangrams(input);
        System.out.println("result = " + result);
        Assert.assertTrue(result.equalsIgnoreCase(expectedResult));
    }
}
