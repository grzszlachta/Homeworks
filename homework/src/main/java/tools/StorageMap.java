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

    public void remove(String good, String magazin) {
        if (good == null || magazin == null || good.isEmpty() || magazin.isEmpty()) {
            throw new IllegalStateException();
        }

        Set<String> records = storage.get(good);
        if (records == null) {
            throw new IllegalStateException();
        }
        records.remove(magazin);
        storage.put(good, records);
    }

    public Set<String> getGoodForStorages(String magazin) {
        Set<String> result = new TreeSet<>();
        for (String good : storage.keySet()) {
            Set<String> records = storage.get(good);
            if (records.contains(magazin)) {
                result.add(good);
            }
        }
        return result;
    }

}
