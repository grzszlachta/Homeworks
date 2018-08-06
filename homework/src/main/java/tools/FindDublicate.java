package tools;

import java.util.ArrayList;
import java.util.List;

public class FindDublicate {

    public static void main(String[] args) {
        System.out.println(hasDublicate("aab"));
        System.out.println(hasDublicate("abc"));
        System.out.println(hasDublicate("aba"));
    }

    public static boolean hasDublicate(String input) {
        List<Character> chars = new ArrayList<>();
        for (char c : input.toCharArray()) {
            chars.add(c);
        }
        long count = chars
                .stream()
                .distinct()
                .count();
        return count != input.length();
    }

}
