package arrays;

public class NumberOfWaysToSplitArrays_2270 {
    /*
        Given an integer array nums, find the number of ways to split the array into two parts so that the
        first section has a sum greater than or equal to the sum of the second section.
        The second section should have at least one number
     */

    public static int waysToSplitArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        int totalWays = 0;
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = 0; i < n - 1; i++) {
            long leftSectionSum = prefixSum[i];
            long rightSectionSum = prefixSum[n - 1] - prefixSum[i];
            if (leftSectionSum >= rightSectionSum) {
                totalWays++;
            }
        }
        System.gc();
        return totalWays;
    }

    public static int waysToSplitArray1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
        int leftSum = 0;
        int rightSum = 0;
        int totalWays = 0;

        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            rightSum = totalSum - leftSum;
            if (leftSum > rightSum) {
                totalWays++;
            }

        }
        return totalWays;
    }


    public static void main(String[] args) {
        int[] nums = {10, 4, -8, 7};
        System.out.println(waysToSplitArray(nums));
        System.out.println(waysToSplitArray1(nums));
        int[] nums1 = {2, 3, 1, 0};
        System.out.println(waysToSplitArray(nums1));
        System.out.println(waysToSplitArray1(nums1));
    }
}
