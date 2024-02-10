package org.k8port.hashmap;

import java.util.List;

/*
* Class represents a HashMap composed of a KeyValues[], where values contained in ArrayList
*/
public class KVHashMapArrayList {

    private static final int CAPACITY = 16; // initial capacity of HashMap
    private final KeyValues[] table;

    public KVHashMapArrayList() {
        this.table = new KeyValues[CAPACITY];
    }

    private int hash(int key) {
        return key % CAPACITY;
    }

    public void put(int key, List<Integer> values) {
        int index = this.hash(key);
        if (table[index] == null) {
            table[index] = new KeyValues(key, values);
        } else {
            for (int value : values) {
                table[index].addValue(value);
            }
        }
    }

    public List<Integer> get(int key) {
        int index = this.hash(key);
        for (KeyValues kv : table) {
            if (kv != null && kv.getKey() == key) {
                return this.table[index].getValues();
            }
        }
        return null;
    }

    public void remove(int key) {
        int index = hash(key);
        for (KeyValues kv : table) {
            if (kv != null && kv.getKey() == key) {
                this.table[index].clearValues();
            }
        }
    }


}
