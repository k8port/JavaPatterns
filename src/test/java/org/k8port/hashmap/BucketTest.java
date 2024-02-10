package org.k8port.hashmap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BucketTest {

    Bucket bucket = new Bucket();

    @BeforeEach
    void setUp() {
        bucket.update(1, 11);
        bucket.update(2, 22);
        bucket.update(3, 33);
    }

    @Test
    void update() {
        bucket.update(9, 99);
        int actualValue = bucket.get(9);
        int expectedValue = 99;
        assertEquals(actualValue, expectedValue);
    }

    @Test
    void get() {
        int actualValue = bucket.get(1);
        int expectedValue = 11;
        assertEquals(actualValue, expectedValue);
    }

    @Test
    void remove() {
        bucket.remove(2);
        int actualValue = bucket.get(2);
        int expectedValue = -1;
        assertEquals(actualValue, expectedValue);
    }
}