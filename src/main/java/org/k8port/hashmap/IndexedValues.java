package org.k8port.hashmap;

import java.util.HashMap;
import java.util.Map;

public class IndexedValues {

    private final int key;
    private int[] values;

    public IndexedValues(int key, int[] values) {
        this.key = key;
        this.values = values;
    }

    public int getKey() {
        return key;
    }

    public int[] getValues() {
        return values;
    }

    public void addValue(int newValue) {
        int[] newValues = new int[this.values.length + 1];
        System.arraycopy(this.values, 0, newValues, 0, values.length);
        newValues[values.length] = newValue;
        values = newValues;
    }

    public Map<Integer, Integer> trackIndex(int targetValue) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            if (values[i] == targetValue) {
                indexMap.put(targetValue, i);
            }
        }
        return indexMap;
    }
}

