package arrays;

import java.util.Arrays;

public class SortedSquares {
    /*
    Input: nums = [-7,-3,2,3,11] // Increasing order
    Output: [4,9,9,49,121]
     */
    public static int[] sortedSquares(int[] nums) {
        // 2 pass solution
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int n = nums.length;
        int firstPositiveIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                firstPositiveIndex = i++;
                break;
            }
        }
        System.out.println("firstPositiveIndex: " + firstPositiveIndex);
        int[] sortedArray = new int[n];
        if (firstPositiveIndex == 0) {
            // easy case
            for (int i = 0; i < n; i++) {
                sortedArray[i] = nums[i] * nums[i];
            }
            return sortedArray;
        } else if (firstPositiveIndex == -1) {
            for (int i = n - 1; i >= 0; i--) {
                sortedArray[n - 1 - i] = nums[i] * nums[i];
            }
            return sortedArray;

        } else {
            int k = 0;
            int left = firstPositiveIndex - 1;
            int right = firstPositiveIndex + 1;
            sortedArray[k++] = nums[firstPositiveIndex] * nums[firstPositiveIndex];

            while (left >= 0 && right <= n - 1) {
                int absLeft = Math.abs(nums[left]);
                int absRight = Math.abs(nums[right]);
                if (absLeft <= absRight) {
                    sortedArray[k++] = absLeft * absLeft;
                    left--;
                } else {
                    sortedArray[k++] = absRight * absRight;
                    right++;
                }
            }
            while (left >= 0) {
                sortedArray[k++] = nums[left] * nums[left];
                left--;
            }
            while (right <= n - 1) {
                sortedArray[k++] = nums[right] * nums[right];
                right++;
            }

        }
        return sortedArray;
    }

    public static int[] sortedSquares1(int[] nums) {
        // One pass solution
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int n = nums.length;
        int[] sortedArray = new int[n];
        if (nums[0] >= 0) {
            // All positive integers
            for (int i = 0; i < n; i++) {
                sortedArray[i] = nums[i] * nums[i];
            }
            return sortedArray;
        } else if (nums[n - 1] < 0) {
            // All negative numbers
            for (int i = 0; i < n; i++) {
                sortedArray[n - 1 - i] = nums[i] * nums[i];
            }
            return sortedArray;
        }

        int i = 0, j = n - 1, k = n - 1;
        while (i <= j) {
            if (Math.abs(nums[i]) >= Math.abs(nums[j])) {
                sortedArray[k--] = nums[i] * nums[i];
                i++;
            } else {
                sortedArray[k--] = nums[j] * nums[j];
                j--;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-2, -1, 0, 1, 2};
        System.out.println(Arrays.toString(sortedSquares(arr)));
        System.out.println(Arrays.toString(sortedSquares1(arr)));
        int[] arr1 = new int[]{0, 1, 2};
        System.out.println(Arrays.toString(sortedSquares(arr1)));
        System.out.println(Arrays.toString(sortedSquares1(arr1)));
        int[] arr2 = new int[]{-3, -2, -1, 0, 1, 2, 3};
        System.out.println(Arrays.toString(sortedSquares(arr2)));
        System.out.println(Arrays.toString(sortedSquares1(arr2)));
        int[] arr3 = new int[]{-3, 0, 1, 2, 8, 9, 10};
        System.out.println(Arrays.toString(sortedSquares(arr3)));
        System.out.println(Arrays.toString(sortedSquares1(arr3)));
        int[] arr4 = new int[]{-30, -5, -1, 0, 6, 21, 33};
        System.out.println(Arrays.toString(sortedSquares(arr4)));
        System.out.println(Arrays.toString(sortedSquares1(arr4)));
    }
}
