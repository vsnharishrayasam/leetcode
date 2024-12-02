package arrays.slidingwindow.fixedWindowSize;

public class KLengthSubArrayWithLargestSum {
    /*
    Given an array of nums and integer k, find the sum of subarray with largest sum of size k
     */

    private static int kLengthSubArrayWithLargestSum(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int sumOfCurrWindow = 0;
        int maxWindowSum = 0;
        // Initial window is first k elements
        for(int i = 0; i < k ; i++) {
            sumOfCurrWindow += nums[i];
        }
        for(int i = k; i < n; i++) {
            sumOfCurrWindow += nums[i]; // Add current element
            sumOfCurrWindow -= nums[i-k]; // remove first element from the window
            maxWindowSum = Math.max(maxWindowSum, sumOfCurrWindow);
        }
        System.gc();
        return maxWindowSum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, -1, 4, 12, -8, 5, 6};
        System.out.println(kLengthSubArrayWithLargestSum(nums, 4));
    }


}
