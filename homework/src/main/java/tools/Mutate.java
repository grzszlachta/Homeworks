package tools;

import java.util.*;

public class Mutate {

    public static void main(String[] args) {
//        System.out.println(isMutateArrays("bog", "dog"));
//        System.out.println(isMutateArrays("dog", "god"));

        System.out.println(isMutateSets("bog", "dog"));
        System.out.println(isMutateSets("dog", "god"));
        System.out.println(isMutateSets("abb", "aab"));

//        System.out.println(isMutateArraysSort("bog", "dog"));
//        System.out.println(isMutateArraysSort("dog", "god"));

//        System.out.println(isMutateMap("bog", "dog"));
//        System.out.println(isMutateMap("dog", "god"));
    }

    public static boolean isMutateArrays(String word1, String word2) {
        if (word1 == null || word2 == null || word1.isEmpty() || word2.isEmpty() || word1.length() != word2.length()) {
            return false;
        }
        if (!checkChars(word1, word2)) return false;
//        if (!checkChars(word2, word1)) return false;
        return true;
    }

    private static boolean checkChars(String word1, String word2) {
        for (char charAt1 : word1.toCharArray()) {
            boolean found = false;
            for (char charAt2 : word2.toCharArray()) {
                if (charAt1 == charAt2) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMutateSets(String word1, String word2) {
        List<Character> wordSet1 = new ArrayList<>();
        for (char charAt : word1.toCharArray()) {
            wordSet1.add(charAt);
        }
        Collections.sort(wordSet1);
        List<Character> wordSet2 = new ArrayList<>();
        for (char charAt : word2.toCharArray()) {
            wordSet2.add(charAt);
        }
        Collections.sort(wordSet2);
        return wordSet1.equals(wordSet2);
    }

    public static boolean isMutateArraysSort(String word1, String word2) {
        char[] chars1 = word1.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = word2.toCharArray();
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }

    public static boolean isMutateMap(String word1, String word2) {
        int[] chars = new int[128];
        for (int i = 0; i < word1.length(); i++) {
            chars[word1.charAt(i)]++;
        }
        for (int i = 0; i < word2.length(); i++) {
            chars[word2.charAt(i)]--;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) return false;
        }
        return true;
    }
}
