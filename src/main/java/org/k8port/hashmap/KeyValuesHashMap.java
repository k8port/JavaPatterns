package org.k8port.hashmap;

import java.util.Arrays;

public class KeyValuesHashMap {

    private static final int CAPACITY = 16;  // initial capacity of HashMap
    private final KeyValuesWithArray[] table;

    public KeyValuesHashMap(KeyValuesWithArray[] table) {
        this.table = table;
    }

    public KeyValuesHashMap() {
        this.table = new KeyValuesWithArray[CAPACITY];
    }

    private int hash(int key) {
        return key % CAPACITY;
    }

    public void put(int key, int[] values) {
        int index = hash(key);
        table[index] = new KeyValuesWithArray(key, values);
    }

    public int[] get(int key) {
        int index = hash(key);
        KeyValuesWithArray keyValuesWithArray = table[index];
        return (keyValuesWithArray != null && keyValuesWithArray.key() == key) ? keyValuesWithArray.values() :
                null;
    }

    public void remove(int key) {
        int index = hash(key);
        table[index] = null;
    }

    @Override
    public String toString() {
        return "KeyValuesHashMap {" +
                "table=" + Arrays.toString(table) +
                '}';
    }
}
