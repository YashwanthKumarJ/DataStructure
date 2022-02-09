package com.yj.datastructures.arrays;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class QueueUsingArray<T> {

    private final T[] elements;

    // front index of queue where elements get added
    private int head = -1;

    // back of the queue where elements will be removed
    private int tail = -1;

    @SuppressWarnings("unchecked")
    public QueueUsingArray(Class<?> type, int size) {
        if (type == null || size < 1) {
            throw new IllegalArgumentException("Invalid input passed. Expected Class<?> and size for Queue");
        }

        elements = (T[]) Array.newInstance(type, size);
    }

    public boolean add(T element) {
        int newIndex = (head + 1) % elements.length;
        if ((tail == -1 && head == elements.length - 1) || newIndex == tail) {
            throw new IllegalStateException("Queue overflow");
        }

        head = newIndex;
        elements[head] = element;

        return true;
    }

    public T remove() {
        if (tail == head) {
            throw new NoSuchElementException();
        }

        tail = (tail + 1) % elements.length;
        return elements[tail];
    }

    public T element() {
        if (tail == head) {
            throw new NoSuchElementException();
        }

        return elements[tail + 1];
    }

    public boolean isEmpty() {
        return tail == head;
    }
}
