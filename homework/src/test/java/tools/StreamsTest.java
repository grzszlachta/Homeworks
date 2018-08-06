package tools;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

    @Test(timeout = 1000)
    public void testStreamGenerateLimit() {
        Supplier<Integer> integerSupplier = () -> new Random().nextInt(100);
        Stream
                .generate(integerSupplier)
                .limit(10)
                .forEach(System.out::println);
    }

    @Ignore("till new year")
    public void testStreamSort() {
        List<String> listOfRandomStrings = Stream
                .generate(() -> generateRandomString(new Random(), 9))
                .peek(System.out::println)
                .limit(25)
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        List<String> toSort = new ArrayList<>(listOfRandomStrings);
        Collections.sort(toSort, Collections.reverseOrder());
        System.out.println("listOfRandomStrings = " + listOfRandomStrings);
        System.out.println("toSort = " + toSort);
        Assert.assertArrayEquals(listOfRandomStrings.toArray(), toSort.toArray());
    }

    @Test
    public void testFilterToCapitalize() {
        List<String> listOfRandomStrings = Stream
                .generate(() -> generateRandomString(new Random(), 9))
                .peek(System.out::println)
                .limit(25)
                .filter(w -> Character.isUpperCase(w.charAt(0)))
                /*.filter(o ->
                        o.substring(0,1)
                            .equals(o.substring(0,1).toUpperCase()))*/
                .collect(Collectors.toList());
        listOfRandomStrings.forEach(
                o -> Assert.assertTrue(
                        o + " is not capitalized",
                        o.substring(0,1)
                                .equals(o.substring(0,1).toUpperCase()))
        );
    }

    @Test
    public void testMapToCapitalize() {
        int capacity = 12;
        List<String> listOfRandomStrings = Stream
                .generate(() -> generateRandomString(new Random(), 9))
                .peek(System.out::println)
                .limit(capacity)
                .map(o -> o.substring(0,1).toUpperCase() + o.substring(1))
                .collect(Collectors.toList());
        listOfRandomStrings.forEach(
                o -> Assert.assertEquals(o + " is not capitalized",
                        o.substring(0, 1), o.substring(0, 1).toUpperCase())
        );
        Assert.assertEquals(listOfRandomStrings.size(), capacity);
    }

    private static String generateRandomString(Random random, int length){
        return random.ints(48,122)
                .filter(i-> (i<57 || i>65) && (i <90 || i>97))
                .mapToObj(i -> (char) i)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();
    }

}
