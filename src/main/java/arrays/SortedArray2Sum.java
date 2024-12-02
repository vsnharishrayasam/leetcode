package arrays;

public class SortedArray2Sum {

    /*
        Given a sorted array and a sum tell if 2 numbers add up to the sum
        nums = [1, 2, 4, 6, 8, 9, 14, 15] and target = 13


     */

    private static boolean findTargetSum(int[] arr, int targetSum) {
        if (arr == null || arr.length == 0) return false;
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == targetSum) {
                return true;
            } else if (sum < targetSum) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 6, 8, 9, 14, 15};
        System.out.println(findTargetSum(arr, 13));
        System.out.println(findTargetSum(arr, 17));
        System.out.println(findTargetSum(arr, 23));
        System.out.println(findTargetSum(arr, 2));
    }
}
