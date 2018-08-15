package tools;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
/*
https://www.hackerrank.com/challenges/pangrams
 */
public class Pangrams {

    public static final String PANGRAM = "pangram";
    public static final String NOT_PANGRAM = "not pangram";

    // Complete the pangrams function below.
    public static String pangrams(String s) {
        Set<Character> chars = new TreeSet<Character>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                chars.add(Character.toLowerCase(c));
            }
        }
        System.out.println(chars);
        String result = (chars.size() == 26) ? "pangram" : "not pangram";
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
