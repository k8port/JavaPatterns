package org.k8port.hashmap;

import java.util.LinkedList;
import java.util.List;

public class BestHashTable<K, V> {

    private static final int INITIAL_CAPACITY = 16;
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    private List<Entry<K, V>>[] table;
    private int size;

    public BestHashTable() {
        this.table = new LinkedList[INITIAL_CAPACITY];
        this.size = 0;
    }

    private int hash(K key) {
        return key.hashCode() % table.length;
    }

    private void resizeTable() {
        int newCapacity = table.length * 2;
        List<Entry<K, V>>[] newTable = new LinkedList[newCapacity];

        for (List<Entry<K, V>> bucket : table) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    int newIndex = hash(entry.getKey());
                    if (newTable[newIndex] == null) {
                        newTable[newIndex] = new LinkedList<>();
                    }
                    newTable[newIndex].add(entry);
                }
            }
        }
        table = newTable;
    }

    public void put(K key, V value) {
        if ((double) size / table.length > LOAD_FACTOR_THRESHOLD) {
            resizeTable();
        }

        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            table[index].removeIf(entry -> entry.getKey().equals(key));
            size--;
        }
    }

    public int size() {
        return size;
    }

    private static class Entry<K, V>  {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
