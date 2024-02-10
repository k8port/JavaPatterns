package org.k8port.hashmap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KeyValuesHashMapTest {

    public static final KeyValuesHashMap keyValuesHashMap = new KeyValuesHashMap();
    public static final int key1 = 1;
    public static final int key2 = 2;
    public static final int key3 = 3;
    public static final int[] arr1 = {1, 2, 3};
    public static final int[] arr2 = {4, 5, 6};
    public static final int[] arr3 = {7, 8, 9};

    @BeforeAll
    static void setUp() {
        keyValuesHashMap.put(key1, arr1);
        keyValuesHashMap.put(key2, arr2);
        keyValuesHashMap.put(key3, arr3);
    }

    @Test
    void put() {
        System.out.printf("{%s}: [", key1);
        int[] valuesArr = keyValuesHashMap.get(key1);
        for (int i = 0; i < valuesArr.length; i++) {
            System.out.printf("%d", valuesArr[i]);
            System.out.print(i < valuesArr.length - 1 ? ", " : "]\n");
            assertEquals(arr1[i], valuesArr[i]);
        }
    }

    @Test
    void get() {
        System.out.printf("{%s}: [", key2);
        int[] valuesArr = keyValuesHashMap.get(key2);
        for (int i = 0; i < valuesArr.length; i++) {
            System.out.printf("%d", valuesArr[i]);
            System.out.print(i < valuesArr.length - 1 ? ", " : "]\n");
            assertEquals(arr2[i], valuesArr[i]);
        }
    }

    @Test
    void remove() {
        keyValuesHashMap.remove(key3);
        int[] removedValues = keyValuesHashMap.get(key3);
        assertNull(removedValues);
    }
}