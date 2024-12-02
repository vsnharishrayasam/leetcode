package arrays.slidingwindow.fixedWindowSize;

import java.util.Arrays;

public class KRadiusSubArrayAvg {

    public int[] getAverages1(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        int d = 2 * k + 1;
        if (k == 0) {
            return nums;

        }

        if (n < d) {
            return arr;

        }

        long[] sumarr = new long[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
            sumarr[i] = sum;
        }

        for (int i = k; i + k < n; i++) {
            if (i - k > 0) {
                arr[i] = (int) ((sumarr[i + k] - sumarr[i - k - 1]) / (2 * k + 1));
            } else if (i - k == 0) {
                arr[i] = (int) ((sumarr[i + k]) / (2 * k + 1));
            }

        }
        return arr;
    }

    public static int[] getAverages(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return nums;
        }
        int n = nums.length;
        int[] averages = new int[n];
        Arrays.fill(averages, -1);
        if (n < (2 * k + 1)) {
            return averages;
        }
        long currSum = 0;
        // compute initial window
        for (int i = 0; i < (2*k + 1); i++) {
            currSum += nums[i];
        }
        averages[k] = (int) (currSum / (2 * k + 1));
        for (int i = k + 1; i < n - k; i++) {
            currSum -= nums[i - k - 1];
            currSum += nums[i+k];
            System.out.println("Indexes: " + (i-k-1) + " -> " + (2 * k + 1));
            averages[i] = (int) (currSum / (2 * k + 1));
        }


        return averages;
    }

    public static void main(String[] args) {
//        int[] nums = {7, 4, 3, 9, 1, 8, 5, 2, 6};
//        System.out.println(Arrays.toString(getAverages(nums, 3)));
//        int[] nums1 = {100000};
//        System.out.println(Arrays.toString(getAverages(nums1, 0)));
//        int[] nums2 = {8};
//        System.out.println(Arrays.toString(getAverages(nums2, 100000)));
        int[] nums3 = {40527,53696,10730,66491,62141,83909,78635,18560};
        System.out.println(Arrays.toString(getAverages(nums3, 2)));

    }
}
