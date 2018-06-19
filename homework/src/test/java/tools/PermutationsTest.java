package tools;

import org.junit.Test;

import java.util.UUID;

public class PermutationsTest {

    @Test
    public void test0Empty() {
        System.out.println("Permutations of empty: [" + test("") + "]\n");
    }

    @Test
    public void test1Alone() {
        System.out.println("Permutations of alone: [" + test(getRandomString(1)) + "]\n");
    }

    @Test
    public void test2Double() {
        System.out.println("Permutations of double: ["+ test(getRandomString(2)) + "]\n");
    }

    @Test
    public void test3Tree() {
        System.out.println("Permutations of three: ["+ test("abc") + "]\n");
    }

    @Test
    public void test4Four() {
        System.out.println("Permutations of four: ["+ test("abcd") + "]\n");
    }

    @Test
    public void test5Five() {
        System.out.println("Permutations of five: ["+ test("abcde") + "]\n");
    }

    private String test(String input) {
        String allPermutations = Permutations.getAllPermutations(input);
        int count = allPermutations.split(" ").length;
        System.out.println("count = " + count);
        return allPermutations;
    }

    private static String getRandomString(int length) {
        return UUID.randomUUID().toString().substring(0, length);
    }

}
