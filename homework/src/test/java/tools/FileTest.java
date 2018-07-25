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
        fileInput.listFiles(new FileFilter() {
            @Override
            public boolean accept(final File pathname) {
                printDirectoryContain(pathname);
                return false;
            }
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

}
