/**
 * Given two sorted array, this class function will find the median of the array elements.
 * Example 1:
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2
 *
 * Example 2:
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5
 *
 * @author Yashwanth
 */
package com.github.yashwanth.datastructure.array;

public class FindMedianInTwoSortedArray {
    public static void main(String[] args) {
        Integer a = 100, b = 100;
        Integer c = 1000, d = 1000;

        System.out.println((a == b) + ", " + (c == d));
    }
    public static double findMedianSortedArrays (int[] nums1, int[] nums2) {
        if ((nums1 == null || nums2 == null) || (nums1.length == 0 && nums2.length == 0)) {
            return -1;
        } else if (nums1.length == 0 || nums2.length == 0) {
            if (nums1.length == 0) {
                if (nums2.length % 2 != 0) {
                    return nums2[nums2.length / 2];
                }

                return (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0;
            }
            else {
                if (nums1.length % 2 != 0) {
                    return nums1[nums1.length / 2];
                }

                return (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0;
            }
        } else {
            int it = (nums1.length + nums2.length) / 2 + 1;

            int first = 0;
            int second = 0;
            int i = 0;
            int j = 0;
            while (it > 0) {
                first = second;

                if (i == nums1.length) {
                    second = nums2[j];
                    j++;
                }
                else if (j == nums2.length) {
                    second = nums1[i];
                    i++;
                }
                else if (nums1[i] < nums2[j]) {
                    second = nums1[i];
                    i++;
                }
                else {
                    second = nums2[j];
                    j++;
                }

                it--;
            }

            return ((nums1.length + nums2.length) % 2 == 0) ? (first + second) / 2.0 : second;
        }
    }
}
