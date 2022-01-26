package com.yj.datastructures.arrays;

import java.lang.reflect.Array;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
    }

    @SuppressWarnings("unchecked")
    public <T> T[] createArray(Class<T> type, int size) {
        return (T[]) Array.newInstance(type, size);
    }

    public <T> void addElement(T[] inputArray, int index, T data) {
        inputArray[index] = data;
    }
}
