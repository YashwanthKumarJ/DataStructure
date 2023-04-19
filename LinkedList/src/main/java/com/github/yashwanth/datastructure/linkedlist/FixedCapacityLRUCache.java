/**
 * Design a data structure that follows the constraints of Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * https://leetcode.com/problems/lru-cache/description/
 *
 * @author Yashwanth
 */
package com.github.yashwanth.datastructure.linkedlist;

import com.github.yashwanth.datastructure.linkedlist.model.MaxSizeLinkedHashMap;

public class FixedCapacityLRUCache
{
    // Fixed size (custom) map extended from LinkedHashMap
    private MaxSizeLinkedHashMap<Integer, Integer> map;

    public FixedCapacityLRUCache (int capacity) {
        this.map = new MaxSizeLinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        Integer value = map.get(key);
        return value == null ? -1 : value;
    }

    public void put(int key, int value) {
        map.put(key, value);
    }
}
