/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package median.of.two.sorted.arrays;

/**
 *
 * @author ASUS
 */
public class MedianOfTwoSortedArrays {

    /**
     * @param args the command line arguments
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        int total = m + n;
        int half = (total + 1) / 2;
        
        while (left <= right) {
            int partition1 = (left + right) / 2;
            int partition2 = half - partition1;
            
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];
            
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if (total % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                right = partition1 - 1;
            } else {
                left = partition1 + 1;
            }
        }
        
        throw new IllegalArgumentException("Input arrays are not sorted.");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("Example 1: " + findMedianSortedArrays(nums1, nums2)); // Output: 2.0

        // Example 2
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println("Example 2: " + findMedianSortedArrays(nums3, nums4)); // Output: 2.5
    }
}
