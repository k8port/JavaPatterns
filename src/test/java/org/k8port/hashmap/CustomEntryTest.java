package org.k8port.hashmap;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CustomEntryTest {


    public final int keyA = 59;
    public final int keyB = 62;
    public final int keyC = 20;
    int[] valA = new int[]{4, 56, 34, 23, 60};
    int[] valB = new int[]{4, 56, 34, 23, 60};
    int[] valC = new int[]{18, 8, 61, 29, 40};

    @Test
    void getKey() {
        ArrayList<Integer> aList = arrToArrList(valA);
        CustomEntry ce = new CustomEntry(keyA, aList);
        int actualKey = ce.getKey();
        assertEquals(keyA, actualKey);
    }

    @Test
    void getValues() {
        ArrayList<Integer> bList = arrToArrList(valB);
        CustomEntry ce = new CustomEntry(keyB, bList);
        List<Integer> actualValues = ce.getValues();
        assertEquals(bList, actualValues);
    }

    @Test
    void addValues() {
        ArrayList<Integer> cList = arrToArrList(valC);
        CustomEntry ce = new CustomEntry(keyC, cList);
        ce.addValues(arrToArrList(valB));
        int[] concatArray = Arrays.copyOf(valC, valC.length + valB.length);
        System.arraycopy(valB, 0, concatArray, valC.length, valB.length);
        List<Integer> expectedValues = arrToArrList(concatArray);
        List<Integer> actualValues = ce.getValues();
        assertEquals(expectedValues, actualValues);
    }

    private static ArrayList<Integer> arrToArrList(int[] arr) {
        return (ArrayList<Integer>)
                Arrays.stream(arr).boxed()
                        .collect(Collectors.toList());
    }

}