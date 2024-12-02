package arrays.slidingwindow.dynamicWindowSize;

public class LengthOfSmallestSubArraySumGreaterThanK_209 {
    private static int lengthOfSmallestSubArraySumGreaterThanK_209(int[] nums, int targetSum) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int l = 0;
        int smallestSubArrayLength = Integer.MAX_VALUE;
        int currSum = 0;
        // 2,3,1,2,4,3 (7)
        for (int r = 0; r < n; r++) {
            currSum += nums[r];
            while (currSum >= targetSum) {
                if (currSum - nums[l] >= targetSum) {
                    currSum -= nums[l];
                    l++;
                } else {
                    smallestSubArrayLength = Math.min(smallestSubArrayLength, r - l + 1);
                    break;
                }
            }

        }
        System.gc();
        return smallestSubArrayLength == Integer.MAX_VALUE ? 0 : smallestSubArrayLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfSmallestSubArraySumGreaterThanK_209(new int[]{2, 3, 1, 2, 4, 3}, 7));
        System.out.println(lengthOfSmallestSubArraySumGreaterThanK_209(new int[]{1, 4, 4}, 4));
        System.out.println(lengthOfSmallestSubArraySumGreaterThanK_209(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, 11));
    }

}
