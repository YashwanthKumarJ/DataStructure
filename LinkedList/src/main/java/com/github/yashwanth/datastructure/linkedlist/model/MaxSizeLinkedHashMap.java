/**
 * Fixed length LinkedHashMap
 * Existing LinkedHashMap is unbounded and size can extend until MAXIMUM_CAPACITY. In order to
 *
 */
package com.github.yashwanth.datastructure.linkedlist.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class MaxSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {

    private final int maxSize;

    public MaxSizeLinkedHashMap(int maxSize, float loadFactor, boolean lruOrder) {
        super(maxSize, loadFactor, lruOrder);
        this.maxSize = maxSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxSize;
    }
}
