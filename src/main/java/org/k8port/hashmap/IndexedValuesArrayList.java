package org.k8port.hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class IndexedValuesArrayList {

    private int key;
    private List<Integer> values;
    private AtomicInteger trackedIndex;

    public IndexedValuesArrayList(int key, List<Integer> values) {
        this.key = key;
        this.values = new ArrayList<>(values);
        this.trackedIndex = new AtomicInteger(-1);
    }

    public int getKey() {
        return this.key;
    }

    public List<Integer> getValues() {
        return this.values;
    }

    public int getTrackedIndex() {
        return this.trackedIndex.get();
    }

    public void setTrackedIndex(int targetValue) {
        this.trackedIndex.set(values.indexOf(targetValue));
    }

    public void addValue(int number) {
        values.add(number);
    }
}
