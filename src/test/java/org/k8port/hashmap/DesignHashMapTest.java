package org.k8port.hashmap;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DesignHashMapTest {

    static int keySpace;
    static DesignHashMap inputHashMap;
    static List<Integer> keysList;
    static List<String> functions;
    static List<List<Integer>> functionKeys;

    @BeforeAll
    static void setUp() {
        keySpace = 11;
        inputHashMap = new DesignHashMap(keySpace);

        keysList = new ArrayList<>(Arrays.asList(5, 11, 12, 15, 22, 10));

        functions = Arrays.asList("Get", "Get", "Put", "Get", "Put", "Get", "Get", "Remove", "Get", "Get", "Remove", "Get");

        functionKeys = Arrays.asList(
                Arrays.asList(5), Arrays.asList(15), Arrays.asList(15, 250),
                Arrays.asList(15), Arrays.asList(121, 10), Arrays.asList(121),
                Arrays.asList(10), Arrays.asList(11), Arrays.asList(11),
                Arrays.asList(13), Arrays.asList(13), Arrays.asList(0));


        for (int i = 0; i < functions.size(); i++) {
            Integer key = functionKeys.get(i).get(0);
            Integer val = functionKeys.get(i).get(1);
            if (functions.get(i).equals("Put")) {
                System.out.println(i + 1 + ".\t put(" + key + ", " + val + ")");
                if (!keysList.contains(key)) {
                    keysList.add(key);
                }
                inputHashMap.put(key, val);
            } else if (functions.get(i).equals("Get")) {
                System.out.println(i + 1 + ".\t get(" + key + ")");
                System.out.println("\t Value returned: " + inputHashMap.get(key));
            } else if (functions.get(i).equals("Remove")) {
                System.out.println(i + 1 + ".\t remove(" + key + ")");
                inputHashMap.remove(key);
            }

            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

    @Test
    void put() {
    }

    @Test
    void get() {
    }

    @Test
    void remove() {
    }
}