package com.github.yashwanth.datastructure.array;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Unit test finding median in two sorted array")
public class FindMedianInTwoSortedArrayTest
{

    @Test
    public void testFirstNullList() {
        assertEquals(-1, FindMedianInTwoSortedArray.findMedianSortedArrays(null, new int[]{}));
    }

    @Test
    public void testSecondNullList() {
        assertEquals(-1, FindMedianInTwoSortedArray.findMedianSortedArrays(new int[]{}, null));
    }
}
