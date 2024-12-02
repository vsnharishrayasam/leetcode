package arrays.slidingwindow.fixedWindowSize;

/* You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value
and return this value. Any answer with a calculation error less than 10-5 will be accepted
 */

public class FindMaxAverageOfLengthK {
    private static double findMaxAverageOfLengthK(int[] nums, int k)  {
        if(nums == null || nums.length == 0 || k > nums.length) {
            return 0;
        }
        int n = nums.length;
        double currAvg = 0;
        double maxAvg = Double.NEGATIVE_INFINITY;
        // Find initial window
        for(int i = 0; i < k; i++) {
            currAvg += (double) nums[i] /k;
        }
        maxAvg = Math.max(maxAvg, currAvg);
        for(int i = k; i < n ; i++) {
            currAvg += (double) nums[i] /k;
            currAvg -= (double) nums[i-k] /k;
            maxAvg = Math.max(maxAvg, currAvg);
        }
        System.gc();
        return maxAvg;
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {1,12,-5,-6,50,3};
//        System.out.println(findMaxAverageOfLengthK(nums, 4));
//        int[] nums1 = new int[] {5};
//        System.out.println(findMaxAverageOfLengthK(nums1, 1));
        int[] nums2 = new int[] {-1};
        System.out.println(findMaxAverageOfLengthK(nums2, 1));

    }
}
