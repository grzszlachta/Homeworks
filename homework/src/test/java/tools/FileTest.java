package tools;

import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileTest {

    @Test
    public void testReadFileByScanner() {

        File fileInput = new File("src\\main\\java\\docs\\Mickiewicz.txt");
        Scanner in = null;
        try {
            in = new Scanner(fileInput);
//            in.useDelimiter("\n");
            while (in.hasNext()) {
                System.out.println("in.next() = " + in.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }

    }

    @Test
    public void testReadFileByScannerWithResources() {

        File fileInput = new File("src\\main\\java\\docs\\Mickiewicz.txt");
        try (Scanner in = new Scanner(fileInput)) {
//            System.out.println("file is directory: " + fileInput.isDirectory());
            while (in.hasNext()) {
                System.out.println("in.next() = " + in.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testReadFileByLines() {
        Path path = Paths.get("src\\main\\java\\docs\\Mickiewicz.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                System.out.println("line = " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCountEmptyLines() {
        Path path = Paths.get("src\\main\\java\\docs\\Mickiewicz.txt");
        int counter = 0;
        int counterAll = 0;
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                if (line.isEmpty()) {
                    counter++;
                }
                counterAll++;
//                System.out.println("line = " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("counter = " + counter);
        System.out.println("counterAll = " + counterAll);
    }

    @Test
    public void testReadFileByScannerDictionary() {
        File fileInput = new File("src\\main\\java\\docs\\Mickiewicz.txt");
        Scanner in = null;
        Map<String, Integer> dict = new HashMap<>();
        try {
            in = new Scanner(fileInput);
            while (in.hasNext()) {
                String next = in.next();
                if (dict.containsKey(next)) {
                    int oldValue = dict.get(next);
                    dict.put(next, ++oldValue);
                } else {
                    dict.put(next, 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }
//        System.out.println("dict = " + dict);
       /*for (Map.Entry<String, Integer> entry : dict.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("entry = " + entry);
            }
       }*/
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(dict.entrySet());
        /*Comparator<Map.Entry<String, Integer>> compMaps = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };*/
        /*MapsComparator comparator = new MapsComparator();
        Collections.sort(entries, comparator);*/
        Collections.sort(entries,
                (o1, o2) -> o2.getValue() - o1.getValue()
        );
        System.out.println("most frequent word is [" + entries.get(0).getKey() + "]");
    }

    @Test
    public void testListFiles() {
        File fileInput = new File("src\\main\\java");
        final String ext = ".txt";
        System.out.println(Arrays.asList(fileInput.listFiles(
                pathname -> pathname.getName().endsWith(ext)))
        );
        System.out.println(Arrays.asList(fileInput.listFiles(
                path -> true
        )));
    }

    @Test
    public void testTreeFiles() {
        File fileInput = new File("src\\main\\java");
        final String ext = ".java";
        System.out.println(Arrays.asList(fileInput.listFiles(new FileFilter() {
            @Override
            public boolean accept(final File pathname) {
                if (pathname.isFile()) {
                    if (pathname.getName().endsWith(ext)) {
                        System.out.println(pathname);
                    }
                } else {
                    System.out.println("Directory is " + pathname);
                    File[] files = pathname.listFiles();
//                    System.out.println(Arrays.asList(files));
                    /*for (File f : files) {
                        System.out.println(f);
                    }*/
                    List<File> listOfFiles = Arrays.asList(files);
                    listOfFiles.forEach(System.out::println);
                    System.out.println();
                }
                return false;
            }
        })));
    }

    @Test
    public void testFullTree() {
        File fileInput = new File("src");
        fileInput.listFiles(pathname -> {
            printDirectoryContain(pathname);
            return false;
        });
    }

    private void printDirectoryContain(File pathname) {
        if (pathname.isFile()) {
            System.out.println(pathname + "  ");
        } else {
            System.out.println("Directory is " + pathname + "  ");
            List<File> listOfFiles = Arrays.asList(pathname.listFiles());
            listOfFiles.forEach(file -> printDirectoryContain(file));
            System.out.println();
        }
    }

    @Test
    public void testOptionalEmpty() {
        Optional<Object> opt1 = Optional.empty();
        if (opt1.isPresent()) {
            System.out.println("Its NOT empty!");
        } else {
            System.out.println("Its empty!");
            System.out.println("opt1 = " + opt1.orElse("Default"));
        }
    }

    @Test
    public void testOptionalPresent() {
        Optional<Object> opt1 = Optional.of("Present");
        if (opt1.isPresent()) {
            System.out.println("Its NOT empty!");
            System.out.println("opt1 = " + opt1.get());
        } else {
            System.out.println("Its empty!");
        }
    }

    @Test
    public void testStream() {
        Stream stream = Stream.of("First", "Second", "Third");
//        stream.forEach(System.out::println);
        stream
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    @Test
    public void testStreamFromCollection() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        Stream<Integer> stream = numbers.stream();
        stream
                .filter(element -> element % 2 == 0)
                .map(element -> element * 2)
                .peek(System.out::println)
                .collect(Collectors.toList())
        ;
    }

    @Test
    public void testStreamGenerate() {
        Stream<Integer> stream = Stream
                .generate(new Random()::nextInt)
                .limit(10);
        stream
                .filter(element -> element % 2 == 0)
                .map(element -> element * 2)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    @Test
    public void testStreamCollectionNotChanged() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> stream = input.stream();
        List<Integer> collected = stream
                .filter(element -> element % 2 == 0)
                .map(element -> element * 2)
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println("input = " + input);
        System.out.println("collected = " + collected);
    }

    @Test
    public void testStreamStats() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> stream = input.stream();
        IntSummaryStatistics intSummaryStatistics = stream
                .filter(element -> element % 2 == 0)
                .peek(System.out::println)
                .mapToInt(e -> e)
//                .mapToInt(element -> element * 2)
                .summaryStatistics();
        System.out.println("input = " + input);
        System.out.println("intSummaryStatistics = " + intSummaryStatistics);
    }

    @Test
    public void testStreamOptional() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> stream = input.stream();
        Optional<Integer> found = stream
                .filter(element -> element > 50)
                .findAny();
        System.out.println("input = " + input);
        System.out.println("found = " + found.orElse(-1));
    }

}
