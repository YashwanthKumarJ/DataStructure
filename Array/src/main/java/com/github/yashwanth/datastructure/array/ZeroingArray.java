/**
 * This class provides solution to a problem where we need to decrement the values by lowest
 * number within the array. Repeat the process until array becomes zero. Find out how many iterations
 * are needed to make the array zero. No negative elements in array
 *
 * Ex: [1,5,0,9]  No negative elements
 * iteration 1 : 1 being the least after 0. Note: we need to make array 0 so no need to consider 0
 * [0, 4, 0, 8] after subtracting 1 from the elements. we need not decrement 0
 *
 * iteration 2 : 4 being the next least element in the array
 * [0, 0, 0, 4]  after subtracting 4 from the array
 *
 * iteration 3 : 4 being the only element left in the array
 * [0,0,0,0]
 *
 * Result : 3 we need this many iterations to make all the elements 0 in the array
 *
 * @author Yashwanth
 */
package com.github.yashwanth.datastructure.array;

import java.util.Arrays;

public class ZeroingArray {
    public static void main (String[] args) {
        int[] input = new int[] { 0,1,1,1};
        System.out.println(calculateOperationCount(input));
    }

    /*
    In this approach, we sort the array in ascending order. We then iterate over the array where
    ever there is an increase in the value we increment the counter, without doing actual subtraction.
    Infact we don't have to subtract, just by checking the numbers we will get to know the count.
     */
    public static int calculateOperationCount(int[] nums) {
        int count = 0;
        if (nums == null || nums.length == 0 ) {
            return count;
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; ) {
            // Skip all identical values following value at i, as they will become zero when subtracting
            int j;
            for(j=i+1; j<nums.length && nums[j] == nums[i]; j++);

            // Start the next element from j
            i = j;

            // Increment the count to mark the operation
            count++;
        }

        return (nums[0] == 0) ? count - 1: count;
    }
}
