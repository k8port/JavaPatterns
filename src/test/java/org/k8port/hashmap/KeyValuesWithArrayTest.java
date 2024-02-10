package org.k8port.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyValuesWithArrayTest {

    public final int[] testValues = {5, 6, 29, 54, 70};
    public final int testKey = 42;
    public final KeyValuesWithArray keyValuesWithArray = new KeyValuesWithArray(testKey, testValues);

    @Test
    void getValues() {
        int[] result = keyValuesWithArray.values();
        assertArrayEquals(testValues, result);
    }

    @Test
    void getKey() {
        int result = keyValuesWithArray.key();
        assertEquals(testKey, result);
    }
}