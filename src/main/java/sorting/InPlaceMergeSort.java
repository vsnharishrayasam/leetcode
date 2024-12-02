package sorting;

import java.util.ArrayList;

public class InPlaceMergeSort {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(6);
        arr.add(1);
        arr.add(4);
        arr.add(2);
        arr.add(5);
        arr.add(3);

        mergeSort(arr, 0, arr.size() - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void mergeSort(ArrayList<Integer> arr, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + (end - start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        inPlaceMerge(arr, start, mid, end);
    }

    private static void inPlaceMerge(ArrayList<Integer> arr, int start, int mid, int end) {
        // first half - start to mid
        // second half - mid+1 to end
        if (mid + 1 <= end && arr.get(mid) < arr.get(mid + 1)) {
            //1,2   3,4
            return;
        }

        int i = start;
        int j = mid + 1;
        while (i <= mid && j <= end) {
            if (arr.get(i) <= arr.get(j)) {
                // 1,2 3
                i++;
            } else if (arr.get(i) > arr.get(j)) {
                //shift all elements to right
                // 1,4,6   2,3,5
                // 1 2 4 6 3 5
                while (j < end && arr.get(i) > arr.get(j)) {
                    j++;
                }
                int temp = arr.get(j);
                int k = j - 1;
                while (k >= i) {
                    arr.set(k + 1, arr.get(k));
                    k--;
                }
                arr.set(i, temp);
            }
        }

    }
}