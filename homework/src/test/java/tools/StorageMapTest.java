package tools;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class StorageMapTest {

    @Test
    public void addOne() {
        StorageMap storageMap = new StorageMap();
        Assert.assertEquals(0, storageMap.get("orange").size());
        storageMap.put("orange", "A");
        Set<String> orangeStorages = storageMap.get("orange");
        Assert.assertEquals(1, orangeStorages.size());
        Assert.assertTrue(orangeStorages.contains("A"));
    }
}
