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

    @Test
    public void addTwo() {
        StorageMap storageMap = new StorageMap();
        Assert.assertEquals(0, storageMap.get("orange").size());
        storageMap.put("orange", "A");
        storageMap.put("apple", "B");
        Set<String> orangeStorages = storageMap.get("orange");
        Assert.assertEquals(1, orangeStorages.size());
        Assert.assertTrue(orangeStorages.contains("A"));
        Set<String> appleStorages = storageMap.get("apple");
        Assert.assertEquals(1, appleStorages.size());
        Assert.assertTrue(appleStorages.contains("B"));
    }

    @Test(expected = IllegalStateException.class)
    public void removeZero() {
        StorageMap storageMap = new StorageMap();
        storageMap.remove("orange", "A");
    }

    @Test
    public void removeOne() {
        StorageMap storageMap = new StorageMap();
        storageMap.put("orange", "A");
        storageMap.remove("orange", "A");
        Set<String> orangeStorages = storageMap.get("orange");
        Assert.assertEquals(0, orangeStorages.size());
    }

    @Test
    public void removeTwo() {
        StorageMap storageMap = new StorageMap();
        storageMap.put("orange", "A");
        storageMap.put("orange", "B");
        Set<String> orangeStoragesBeforeRemoval = storageMap.get("orange");
        Assert.assertEquals(2, orangeStoragesBeforeRemoval.size());
        Assert.assertTrue(orangeStoragesBeforeRemoval.contains("A"));
        Assert.assertTrue(orangeStoragesBeforeRemoval.contains("B"));
        storageMap.remove("orange", "A");
        Set<String> orangeStorages = storageMap.get("orange");
        Assert.assertEquals(1, orangeStorages.size());
        Assert.assertTrue(orangeStorages.contains("B"));
    }

    @Test
    public void getStoragesForGood() {
        StorageMap storageMap = new StorageMap();
        storageMap.put("orange", "A");
        storageMap.put("apple", "B");
        storageMap.put("tomato", "B");
        Set<String> aStorage = storageMap.getGoodForStorages("A");
        Assert.assertEquals(1, aStorage.size());
        Assert.assertTrue(aStorage.contains("orange"));
        Set<String> bStorage = storageMap.getGoodForStorages("B");
        Assert.assertEquals(2, bStorage.size());
        Assert.assertTrue(bStorage.contains("apple"));
        Assert.assertTrue(bStorage.contains("tomato"));
    }

}
