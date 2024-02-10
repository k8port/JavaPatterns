package org.k8port.hashmap;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IndexedValuesArrayListTest {

    public int testKey = 1;
    List<Integer> testValues = List.of(10, 20, 30, 20, 40, 50);

    IndexedValuesArrayList testClass = new IndexedValuesArrayList(testKey, testValues);

    @Test
    public void testGetKey() {
        int expectedKey = 1;
        int actualKey = testClass.getKey();
        assertEquals(expectedKey, actualKey);
    }

    @Test
    public void testGetValues() {
        List<Integer> expectedValues = List.of(10, 20, 30, 20, 40, 50);
        List<Integer> actualValues = testClass.getValues();
    }

    @Test
    public void testGetTrackedIndex() {
        int targetValue = 20;
        testClass.setTrackedIndex(targetValue);
        int expectedIndex = 1;
        int actualIndex = testClass.getTrackedIndex();
        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testAddValue() {
        int newValue = 75;
        testClass.addValue(newValue);
        List<Integer> actualValues = testClass.getValues();
        assertTrue(actualValues.contains(newValue));
    }
}