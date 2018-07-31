package tools;

import org.junit.Assert;
import org.junit.Test;

public class LeapYearTest {

    @Test
    public void test1997() {
        Assert.assertFalse(LeapYear.isLeap(1997));
    }

    @Test
    public void test2012() {
        Assert.assertTrue(LeapYear.isLeap(2012));
    }

    @Test
    public void test2000() {
        Assert.assertTrue(LeapYear.isLeap(2000));
    }

    @Test
    public void test1900() {
        Assert.assertFalse(LeapYear.isLeap(1900));
    }
}
