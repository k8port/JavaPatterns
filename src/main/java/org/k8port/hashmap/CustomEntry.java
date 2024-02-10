package org.k8port.hashmap;

import java.util.LinkedList;
import java.util.List;

public class CustomEntry {

    private final int key;
    private final List<Integer> values = new LinkedList<>();

    public CustomEntry(int key, List<Integer> newValues) {
        this.key = key;
        addValues(newValues);
    }

    public int getKey() {
        return key;
    }

    public List<Integer> getValues() {
        return values;
    }

    public void addValues(List<Integer> newValues) {
        values.addAll(newValues);
    }
}
