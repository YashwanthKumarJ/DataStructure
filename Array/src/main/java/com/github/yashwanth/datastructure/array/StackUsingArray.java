package com.github.yashwanth.datastructure.array;

import java.lang.reflect.Array;
import java.util.EmptyStackException;

public class StackUsingArray<T> {

    private final T[] elements;

    private int lastIndex = -1;

    @SuppressWarnings("unchecked")
    public StackUsingArray(Class<?> type, int size) {
        if (type == null || size < 1) {
            throw new IllegalArgumentException("Invalid input passed. Expected Class<?> and size for stack");
        }

        elements = (T[]) Array.newInstance(type, size);
    }

    public void push(T element) throws Exception {
        if (lastIndex == elements.length) {
            throw new Exception("Stack is full");
        }

        elements[++lastIndex] = element;
    }

    public T pop() {
        if (lastIndex < 0) {
            throw new EmptyStackException();
        }

        return elements[lastIndex--];
    }

    public T peek() {
        if (lastIndex < 0) {
            throw new EmptyStackException();
        }

        return elements[lastIndex];
    }

    public boolean isEmpty() {
        return lastIndex < 0;
    }
}
