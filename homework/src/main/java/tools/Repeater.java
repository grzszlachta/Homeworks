package tools;

import java.util.Arrays;

public class Repeater {

    public static void main(String[] args) {
        String[] input = {"a", "b"};
        repeat(input, 2);
        repeat(input, 3);
        repeat(input, 4);
    }

    public static String repeat(String[] input, int n) {
        System.out.println("input = " + Arrays.toString(input));
        StringBuilder sb = new StringBuilder();
        for (String letter : input) {
            for (int i = 0; i < n; i++) {
                sb.append(letter);
            }
        }
        String result = sb.toString();
        System.out.println("result = " + result);
        return result;
    }
}
