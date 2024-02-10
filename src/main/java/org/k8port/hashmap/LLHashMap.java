package org.k8port.hashmap;

import java.util.List;

public class LLHashMap {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    private CustomEntry[] table;
    private int size;

    public LLHashMap() {
        this.table = new CustomEntry[INITIAL_CAPACITY];
        this.size = 0;
    }

    private int hash(int key) {
        return key % table.length;
    }

    private void resizeTable() {
        int newCapacity = table.length * 2;
        CustomEntry[] newTable = new CustomEntry[newCapacity];

        for (CustomEntry ce : table) {
            if (ce != null) {
                int newIndex = ce.getKey() % newCapacity;
                if (newTable[newIndex] == null) {
                    newTable[newIndex] = new CustomEntry(ce.getKey(), ce.getValues());
                } else {
                    newTable[newIndex].addValues(ce.getValues());
                }
            }
        }
        table = newTable;
    }

    public void put(int key, List<Integer> values) {
        if ((double) size /table.length > LOAD_FACTOR_THRESHOLD) {
            resizeTable();
        }

        int index = hash(key);
        if (table[index] == null) {
            table[index] = new CustomEntry(key, values);
            size++;
        } else if (table[index].getKey() == key) {
            table[index].addValues(values);
        } else {
            resizeTable();
            put(key, values);
        }
    }

    public List<Integer> get(int key) {
        int index = hash(key);
        if (table[index] != null && table[index].getKey() == key) {
            return table[index].getValues();
        }
        return null;
    }

    public void remove(int  key) {
        int index = hash(key);
        if (table[index] != null && table[index].getKey() == key) {
            table[index] = null;
            size--;
        }
    }
}
