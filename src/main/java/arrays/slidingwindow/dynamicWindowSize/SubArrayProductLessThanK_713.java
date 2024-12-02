package arrays.slidingwindow.dynamicWindowSize;

public class SubArrayProductLessThanK_713 {
    /*
    Given an array of positive integers nums and an integer k,
    return the number of sub arrays where the product of all the elements in the subarray is strictly less than k.

    For example, given the input nums = [10, 5, 2, 6], k = 100, the answer is 8.
    The subarrays with products less than k are:

    [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
     */
    private static int subArrayProductLessThanK_713(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 1) {
            return 0;
        }
        int n = nums.length;
        int l = 0;
        int currProduct = 1;
        int maxWindow = 0;
        int validSubArraysCount = 0;
        for (int r = 0; r < n; r++) {
            currProduct *= nums[r];
            while (currProduct >= k && l < n) {
                currProduct = currProduct / nums[l];
                l++;
            }
            if (currProduct < k) {
                maxWindow = Math.max(maxWindow, r - l + 1);
                System.out.println("l, r: " + l + ", " + r);
                System.out.println("Length: " + (r-l+1));
                validSubArraysCount += (r-l + 1);
            }
        }
        return validSubArraysCount;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{10, 5, 2, 6};
        System.out.println(subArrayProductLessThanK_713(nums1, 100));
        int[] nums2 = new int[]{1, 2, 3, 4, 5};
        System.out.println(subArrayProductLessThanK_713(nums2, 1));
    }

}
