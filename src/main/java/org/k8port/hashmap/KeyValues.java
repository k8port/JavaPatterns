package org.k8port.hashmap;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * Class takes an int key and stores and int array of values
 * keys are unique
 */
public class KeyValues {

    private final int key;
    private final List<Integer> values;


    public KeyValues(int key, List<Integer> values) {
        this.key = key;
        this.values = new ArrayList<>(values);
    }

    public int getKey() {
        return key;
    }

    public ArrayList<Integer> getValues() {
        return (ArrayList<Integer>) values;
    }

    public void addValue(int valueNumber) {
        values.add(valueNumber);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        KeyValues objValues = (KeyValues) o;
        return key == objValues.getKey() && this.getValues().equals(objValues.getValues());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getKey(), getValues());
    }

    @Override
    public String toString() {
        return "KeyValue {" +
                "key=" + key +
                ", values=" + values +
                '}';
    }

    public void clearValues() {
        this.values.clear();
    }
}
