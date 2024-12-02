package arrays;

import java.util.Arrays;

public class DutchNationalFlag {

    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 0, 2, 1, 0, 2, 1};

        System.out.println(Arrays.toString(rearrange(arr)));

    }

    private static int[] rearrange(int[] arr) {
        if (arr == null || arr.length == 0) return arr;
        int left = 0, right = arr.length - 1;
        int curr = 0;
        while (curr < right) { // check this condition
            if (arr[curr] == 2) {
                //swap with the right and reduce right by 1
                int temp = arr[curr];
                arr[curr] = arr[right];
                arr[right] = temp;
                right--;
            } else if (arr[curr] == 1) {
                curr++;
            } else if (arr[curr] == 0) {
                int temp = arr[curr];
                arr[curr] = arr[left];
                arr[left] = temp;
                left++;
            }
        }


        return arr;


    }

}
