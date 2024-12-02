package arrays;


import java.util.Arrays;

public class prefixsum {
    /*

    Example 1: Given an integer array nums, an array queries where queries[i] = [x, y] and an integer limit,
    return a boolean array that represents the answer to each query. A query is true if the sum of the subarray
    from x to y is less than limit, or false otherwise.

For example, given nums = [1, 6, 3, 2, 7, 2], queries = [[0, 3], [2, 5], [2, 4]], and limit = 13,
 the answer is [true, false, true]. For each query, the subarray sums are [12, 14, 12].
     */

    private static boolean[] answerQueries(int[] nums, int[][] queries, int limit) {
        if (nums == null || nums.length == 0) {
            return new boolean[queries.length];
        }
        int n = nums.length;
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        boolean[] answers = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int sum = (x == 0) ? (prefixSum[y]) : (prefixSum[y] - prefixSum[x - 1]);
            // without this directly we can use prefix[y] - prefix[x] + nums[x]
            System.out.println(prefixSum[y]);
            System.out.println(prefixSum[x]);
            if (sum < limit) {
                answers[i] = true;
            }
        }
        return answers;
    }

    public static void main(String[] args) {
        int[] nums = {1, 6, 3, 2, 7, 2};
        int[][] queries = {
                {0, 3},
                {2, 5},
                {2, 4}
        };
        int limit = 13;
        System.out.println(Arrays.toString(answerQueries(nums, queries, limit)));
    }
}
