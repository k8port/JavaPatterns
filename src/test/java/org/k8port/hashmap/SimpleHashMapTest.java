package org.k8port.hashmap;

import org.junit.jupiter.api.Test;
import org.k8port.hashmap.SimpleHashMap.CustomKey;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class SimpleHashMapTest {

    public static final HashMap<CustomKey, String> hashMap = new HashMap<>();

    public CustomKey key1;
    public CustomKey key2;


    @Test public void testCustomKey() {
        key1 = new CustomKey(1);
        key2 = new CustomKey(2);

        hashMap.put(key1, "value1");
        hashMap.put(key2, "value2");

        String expectedOutput1 = "value1";
        String expectedOutput2 = "value2";
        String actualOutput1 = hashMap.get(key1);
        String actualOutput2 = hashMap.get(key2);

        System.out.println(actualOutput1);
        System.out.println(actualOutput2);

        assertEquals(expectedOutput1, actualOutput1);
        assertEquals(expectedOutput2, actualOutput2);
    }

}
