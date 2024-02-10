package org.k8port.hashmap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KVHashMapArrayListTest {

    public static final KVHashMapArrayList kvList = new KVHashMapArrayList();
    public static final List<Integer> valuesListA = List.of(1, 2, 3, 4, 5);
    public static final List<Integer> valuesListB = List.of(9, 11, 13, 15, 17);
    public static final List<Integer> valuesListC = List.of(71, 17, 40, 3, 28);

    public static final int keyA = 129;
    public static final int keyB = 951;
    public static final int keyC = 531;


    @BeforeAll
    static void setUp() {
        kvList.put(keyA, valuesListA);
        kvList.put(keyB, valuesListB);
        kvList.put(keyC, valuesListC);
    }

    @Test
    void put() {
        System.out.printf("{%s}: [", keyA);
        List<Integer> valuesList = kvList.get(keyA);
        for (int i = 0; i < valuesList.size(); i++) {
            System.out.printf("%d", valuesList.get(i));
            System.out.print(i < valuesList.size() - 1 ? ", " : "]\n");
            assertEquals(valuesListA.get(i), valuesList.get(i));
        }
    }

    @Test
    void get() {
        System.out.printf("{%s}: [", keyB);
        List<Integer> valuesList = kvList.get(keyB);
        for (int i = 0; i < valuesList.size(); i++) {
            System.out.printf("%d", valuesList.get(i));
            System.out.print(i < valuesList.size() - 1 ? ", " : "]\n");
            assertEquals(valuesListB.get(i), valuesList.get(i));
        }
    }

    @Test
    void remove() {
        kvList.remove(keyC);
        List<Integer> removed = kvList.get(keyC);
        assertTrue(removed.isEmpty());
    }
}