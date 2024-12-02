package arrays;

import java.util.Arrays;

public class Combine2SortedArrays {
    /* Given 2 sorted arrays return a new array which is inclusive of all elements in both arrays with repititon
    arr1 = [1, 4, 6], arr2 = [2, 3, 5, 8]
    -> combined = [1, 2, 3, 4, 5, 6, 8]
     */

    private static int[] combine2SortedArrays(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        if (m == 0) return arr2;
        if (n == 0) return arr1;
        int[] arr3 = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (arr1[i] <= arr2[j]) {
                arr3[k++] = arr1[i++];
            } else {
                arr3[k++] = arr2[j++];
            }
        }
        while (i < m) {
            arr3[k++] = arr1[i++];
        }
        while (j < n) {
            arr3[k++] = arr2[j++];
        }
        return arr3;

    }


    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 4, 6};
        int[] arr2 = new int[]{2, 3, 5, 8};
        int[] arr3 = new int[]{1, 2, 3, 4, 5, 6, 8};
        System.out.println(Arrays.equals(arr3, combine2SortedArrays(arr1, arr2)));
        int[] arr4 = new int[]{1, 1, 1};
        int[] arr5 = new int[]{1, 2, 2, 5, 8};
        int[] arr6 = new int[]{1, 1, 1, 1, 2, 2, 5, 8};
        System.out.println(Arrays.equals(arr6, combine2SortedArrays(arr4, arr5)));
    }


}
