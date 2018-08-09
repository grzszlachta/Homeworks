package tools;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class LoopChecker {



    public static boolean hasLoopHashes(LinkedList<Object> input) {
        Iterator<Object> iterator = input.iterator();
        Map<Object, Integer> keyStorage = new HashMap<>();
        while (iterator.hasNext()) {
            Object cursor = iterator.next();
            Integer hash = cursor.hashCode();
            if (keyStorage.values().contains(hash)) {
                return true;
            } else {
                keyStorage.put(cursor, hash);
            }
        }
        return false;
    }

}
