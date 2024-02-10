package org.k8port.hashmap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KeyValuesTest {

    public static final List<Integer> numberListA = new ArrayList<>(List.of(5, 49, 22, 16, 66, 1));
    public static final List<Integer> numberListB = new ArrayList<>(List.of(1, 16, 39, 19, 25, 25));
    public static final List<Integer> numberListC = new ArrayList<>(List.of(40, 13, 12, 69, 8));
    public static final List<Integer> numberListC1 = new ArrayList<>(List.of(40, 13, 12, 69, 8, 19));
    public static final List<Integer> numberListC2 = new ArrayList<>(List.of(40, 13, 12, 69, 8, 29));
    public static final int testKey = 59;

    @Test
    void testGetKey() {
        System.out.println("\n====================\ntestGetKey(): ");
        KeyValues testKeyValues = new KeyValues(testKey, numberListA);
        int actualKey = testKeyValues.getKey();
        assertEquals(actualKey, testKey);
    }

    @Test
    void testGetValues() {
        System.out.println("\n====================\ntestGetValues(): ");
        KeyValues testKeyValues = new KeyValues(testKey, numberListB);
        List<Integer> actualValues = testKeyValues.getValues();
        assertEquals(numberListB, actualValues);
    }

    @Test
    void testAddValue() {
        System.out.println("\n====================\ntestAddValues(): ");
        KeyValues testKeyValues = new KeyValues(testKey, numberListC);
        testKeyValues.addValue(19);
        List<Integer> actualValues = testKeyValues.getValues();
        assertEquals(actualValues, numberListC1);
    }

    @Test
    void testEquals() {
        System.out.println("\n====================\ntestEquals(): ");
        KeyValues keyValues = new KeyValues(testKey, numberListC);
        keyValues.addValue(29);
        KeyValues testObjA = new KeyValues(testKey, numberListC2);
        KeyValues testObjB = new KeyValues(testKey, numberListC1);
        KeyValues testObjC = new KeyValues((testKey + 1), numberListC2);
        assertTrue(keyValues.equals(testObjA));
        assertFalse(keyValues.equals(testObjB));
        assertFalse(keyValues.equals(testObjC));
    }

    @Test
    void testHashCode() {
        System.out.println("\n====================\ntestHashCode(): ");
        KeyValues testKeyValues = new KeyValues(testKey, numberListC1);
        int hashCode = testKeyValues.hashCode();
        assertNotNull(hashCode);
    }

    @Test
    void testToString() {
        System.out.println("\n====================\ntestToString(): ");
        KeyValues testKeyValues = new KeyValues(testKey, numberListC2);
        String keyValuesStr = testKeyValues.toString();
        System.out.println(keyValuesStr);
    }
}