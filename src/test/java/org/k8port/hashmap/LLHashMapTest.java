package org.k8port.hashmap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LLHashMapTest {

    public static LLHashMap hashMap;
    public static int key1;
    public static int key2;
    public static int key3;
    public static List<Integer> l1;
    public static List<Integer> l2;
    public static List<Integer> l3;

    @BeforeAll
    static void setUp() {
        hashMap = new LLHashMap();
        l1 = List.of(5, 29, 13, 45, 68);
        l2 = List.of(14, 25, 35, 18, 39);
        l3 = List.of(50, 51, 13, 19, 25);

        key1 = 11;
        key2 = 22;
        key3 = 33;

        hashMap.put(key1, l1);
        hashMap.put(key2, l2);
        hashMap.put(key3, l3);
    }

    @Test
    void put() {
        List<Integer> result1 = hashMap.get(key1);
        assertEquals(l1, result1);
    }

    @Test
    void get() {
        List<Integer> result2 = hashMap.get(key2);
        assertEquals(l2, result2);
    }

    @Test
    void remove() {
        hashMap.remove(key3);
        assertNull(hashMap.get(key3));
    }
}