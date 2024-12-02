package arrays.slidingwindow.dynamicWindowSize;

public class LengthofLongestSubArraySumLessThanK {

    /*
    Given an array of positive integers nums and an integer k,
    find the length of the longest subarray whose sum <= k.
     */

    private static int lengthOfLongestSubArraySumLessThanK(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        int left = 0;
        int currSum = 0;
        int maxWindowSize = 0;
        for (int right = 0; right < n; right++) {
            currSum += arr[right];
            while (currSum > k && left < n) {
                currSum -= arr[left];
                left++;
            }
            if (currSum <= k) {
                maxWindowSize = Math.max(maxWindowSize, right - left + 1);
            }
        }
        return maxWindowSize;


    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 2, 7, 4, 2, 1, 1, 5};
        int k = 8;
        System.out.println(lengthOfLongestSubArraySumLessThanK(arr, k));

    }
}
