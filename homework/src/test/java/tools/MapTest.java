package tools;

import org.junit.Test;

import java.util.*;

public class MapTest {

    @Test
    public void testZipLists() {
        List<String> names = Arrays.asList("Andrii", "Ivan", "Jan", "Petro");
        List<String> surnames = Arrays.asList("Mishak", "Ivanov", "Kowalsky", "Petrenko");
        // create a map between names and surnames
        Map<String, String> nameToSurname = null;
    }

    @Test
    public void testSortedKeys() {
        Map<String, Integer> vehicles = new HashMap();
        // Add some vehicles.
        vehicles.put("BMW", 5);
        vehicles.put("Mercedes", 3);
        vehicles.put("Audi", 4);
        vehicles.put("Ford", 10);
        // print map sorted in natural order by key
        System.out.println("vehicles = " + vehicles);
    }
}
