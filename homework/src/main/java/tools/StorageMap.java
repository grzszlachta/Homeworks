package tools;

import java.util.*;

public class StorageMap {

    Map<String, Set<String>> storage = new HashMap<>();

    public void put(String good, String magazin) {
        Set<String> records = storage.get(good);
        if (records == null) {
            records = new HashSet<>();
        }
        records.add(magazin);
        storage.put(good, records);
    }

    public Set<String> get(String good) {
        Set<String> records = storage.get(good);
        return records == null ? Collections.emptySet() : records;
    }

    public void remove(String good, String storage) {

    }

}
