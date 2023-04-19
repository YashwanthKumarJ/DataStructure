package com.github.yashwanth.datastructure.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit test Zeroing Array implementation")
public class ZeroingArrayTest {

    @Test
    public void testOperationCountForNullInput () {
        int result = ZeroingArray.calculateOperationCount(null);
        assertEquals(0, result);
    }

    @Test
    public void testOperationCountForEmptyInput () {
        int result = ZeroingArray.calculateOperationCount(new int[]{});
        assertEquals(0, result);
    }

    @Test
    public void testOperationCountForZeroElementArray () {
        int [] inputArray = {0, 0, 0, 0, 0};
        int result = ZeroingArray.calculateOperationCount(inputArray);
        assertEquals(0, result);
    }

    @Test
    public void testOperationCountForProperArray () {
        int [] inputArray = {1, 2, 3, 4, 5};
        int result = ZeroingArray.calculateOperationCount(inputArray);
        assertEquals(5, result);
    }

    @Test
    public void testOperationCountForDescendingOrderArray () {
        int [] inputArray = {5, 4, 3, 2, 1, 0};
        int result = ZeroingArray.calculateOperationCount(inputArray);
        assertEquals(5, result);
    }

    @Test
    public void testOperationCountForUnOrderArray () {
        int [] inputArray = {4, 0, 1, 5, 3, 0, 2};
        int result = ZeroingArray.calculateOperationCount(inputArray);
        assertEquals(5, result);
    }
}
