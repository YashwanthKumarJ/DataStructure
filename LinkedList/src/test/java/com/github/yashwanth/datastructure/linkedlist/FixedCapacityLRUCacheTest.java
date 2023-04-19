package com.github.yashwanth.datastructure.linkedlist;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Description("Unit test Fixed capacity LRU cache implementation")
public class FixedCapacityLRUCacheTest {

    @Test
    public void testFixedLengthCache() {
        FixedCapacityLRUCache cache = new FixedCapacityLRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        assertEquals(1, cache.get(1));
        assertEquals(2, cache.get(2));

        cache.put(3, 3);

        assertEquals(3, cache.get(3));
        assertEquals(2, cache.get(2));

        // 1 must have been removed as it was least recently used and got removed while inserting 3
        assertEquals(-1, cache.get(1));
    }

    @Test
    public void testLRUCacheOldDataReplacementFunctionality() {
        FixedCapacityLRUCache cache = new FixedCapacityLRUCache(2);
        cache.put(1,1);
        cache.put(2,2);

        // making 1 as recently accessed element/key
        assertEquals(1, cache.get(1));

        cache.put(3, 3);

        assertEquals(1, cache.get(1));
        assertEquals(3, cache.get(3));

        // 2 must have been removed as it was least recently used and got removed while inserting 3
        assertEquals(-1, cache.get(2));
    }

    @Test
    public void testLRUCacheMultipleInsertion() {
        FixedCapacityLRUCache cache = new FixedCapacityLRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);

        assertEquals(-1, cache.get(1));
        assertEquals(-1, cache.get(2));
        assertEquals(3, cache.get(3));
        assertEquals(4, cache.get(4));

        cache.put(5, 5);

        assertEquals(5, cache.get(5));
        assertEquals(4, cache.get(4));
        assertEquals(-1, cache.get(3));

        cache.put(6, 6);

        assertEquals(6, cache.get(6));
        assertEquals(4, cache.get(4));
        assertEquals(-1, cache.get(5));
    }
}
