package arrays.slidingwindow.dynamicWindowSize;

/*
Given a binary array nums and an integer k,
 return the maximum number of consecutive 1's in the array if you can flip at most k 0's */

public class LongestBinaryStringLengthWithkFlips {
    private static int longestBinaryStringLengthWithOneFlip(final String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        int left = 0;
        int countOfZerosSoFar = 0;
        int maxWindowLengthWithAtmostOneZero = 0;

        for (int right = 0; right < n; right++) {
            if (chars[right] == '0') {
                countOfZerosSoFar++;
            }
            while (countOfZerosSoFar > 1 && left < n) {
                if (chars[left] == '0') {
                    countOfZerosSoFar -= 1;
                }
                left++;
            }
            if (countOfZerosSoFar <= 1) {
                maxWindowLengthWithAtmostOneZero = Math.max(maxWindowLengthWithAtmostOneZero, right - left + 1);
            }
        }
        return maxWindowLengthWithAtmostOneZero;
    }

    // 1,0,0,0,1  2
    private static int longestOnesWithKFlips(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n < k) {
            return k;
        }
        int l = 0;
        int curr = 0;
        int maxSize = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) {
                curr++;
            }
            while (curr > k && l < n) {
                if (nums[l] == 0) {
                    curr--;
                }
                l++;
            }
            if (curr <= k) {
                maxSize = Math.max(maxSize, r - l + 1);
            }
        }
        System.gc();
        return maxSize;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(longestOnesWithKFlips(nums, 2));
        int[] nums1 = new int[]{1, 0, 0, 0, 1};
        System.out.println(longestOnesWithKFlips(nums1, 2));
    }
}
