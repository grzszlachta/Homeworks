package tools;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FileTest18 {

    @Test
    public void testWordPositions() {
        Path path = Paths.get("src\\main\\java\\docs\\Mickiewicz.txt");
        Map<String, String> words = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(path);
            for (int lineCounter = 0; lineCounter < lines.size(); lineCounter++) {
                if (lines.get(lineCounter).isEmpty()) {
                    continue;
                }
                String[] wordsInLine = lines.get(lineCounter).split(" ");
                for (int wordCounter = 0; wordCounter < wordsInLine.length; wordCounter++) {
                    words.put((lineCounter + 1) + "_" + (wordCounter + 1), wordsInLine[wordCounter]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("line 42, position 11 => " + words.get("42_11"));
    }

    @Test
    public void testLongestWord() {
        File fileInput = new File("src\\main\\java\\docs\\Mickiewicz.txt");
        try (Scanner in = new Scanner(fileInput)) {
            if (in.hasNext()) {
                String longest = in.next();
                while (in.hasNext()) {
                    String next = in.next();
                    if (longest.length() < next.length()) {
                        longest = next;
                    }
                }
                System.out.println("longest is = [" + longest + "]");
            } else {
                // empty text
                System.out.println("No words at all");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSpecifiedLongestWord() {
        File fileInput = new File("src\\main\\java\\docs\\Mickiewicz.txt");
        Set<String> words = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });
        try (Scanner in = new Scanner(fileInput)) {
            while (in.hasNext()) {
                words.add(in.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("first longest = [" + words.toArray()[0] + "]");
        System.out.println("second longest = [" + words.toArray()[1] + "]");
        System.out.println("third longest = [" + words.toArray()[2] + "]");
        System.out.println("fourth longest = [" + words.toArray()[3] + "]");
    }
}
