package org.k8port.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BestHashTableTest {

    public static BestHashTable<String, Integer> hashTable;

    @BeforeEach
    void setUp() {
        hashTable = new BestHashTable<>();

        hashTable.put("one", 1);
        hashTable.put("two", 2);
        hashTable.put("three", 3);
    }

    @Test
    void get() {
        int expectedValue = 2;
        int actualValue = hashTable.get("two");
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void put() {
        hashTable.put("four", 4);
        int expectedVal = 4;
        int actualVal = hashTable.get("four");
        assertEquals(expectedVal, actualVal);
    }

    @Test
    void remove() {
        hashTable.remove("three");
        assertNull(hashTable.get("three"));
    }
}