package tools;

import java.util.*;

public class TestSet {

    public static void main(String[] args) {
        Set<String> input = new HashSet<>();
        for (int i = 0; i < 13; i++) {
                input.add("A");
                input.add("B");
        }
        System.out.println("input = " + input);
    }
}
