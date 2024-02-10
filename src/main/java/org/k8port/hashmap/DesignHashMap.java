package org.k8port.hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesignHashMap {

    public int keySpace;
    public List<Bucket> hashMap;

    // creates N buckets, where N is the keySpace variable
    public DesignHashMap(int keySpace) {
        this.keySpace = keySpace;
        this.hashMap = new ArrayList<>(Collections.nCopies(keySpace, new Bucket()));
    }

    // adds value of given key to the hashMap at the relevant hash address
    // generates hash key by taking modulus of key with keySpace variable
    // value inserted into bucket at index specified by hash key
    public void put(int key, int value) {
        int hashKey = key % this.keySpace;
        this.hashMap.get(hashKey).update(key, value);
    }

    // fetches corresponding value of a given key
    // generates hash key & searches for key in bucket specified by hash key index
    // returns associated value
    public int get(int key) {
        int hashKey = key % this.keySpace;
        return this.hashMap.get(hashKey).get(key);
    }

    // generates hash key & removes from bucket at index pointed to by hash key
    public void remove(int key) {
        int hashKey = key % this.keySpace;
        this.hashMap.get(hashKey).remove(key);
    }
}
