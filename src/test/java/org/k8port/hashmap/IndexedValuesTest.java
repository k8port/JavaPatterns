package org.k8port.hashmap;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class IndexedValuesTest {

    public int testKey = 1;
    public int[] testValues = {10,  20, 30,  20, 40, 50};

    IndexedValues testIndexedValues = new IndexedValues(testKey, testValues);

    @Test
    void testGetKey() {
        int expectedKey = 1;
        int actualKey = testIndexedValues.getKey();
        assertEquals(expectedKey, actualKey);
    }

    @Test
    void testGetValues() {
        int[] expectedValues = {10,  20, 30,  20, 40, 50};
        int[] actualValues = testIndexedValues.getValues();
    }

    @Test
    void testTrackIndex() {
        int targetValue = 20;
        Map<Integer, Integer> indexMap = testIndexedValues.trackIndex(targetValue);
        assertNotNull(indexMap.get(targetValue));
    }

    @Test
    void testAddValue() {
        int newValue = 75;
        testIndexedValues.addValue(newValue);
        Map<Integer, Integer> indexMap = testIndexedValues.trackIndex(newValue);
        assertNotNull(indexMap);
    }
}