package arrays;

import java.util.ArrayList;

public class DiagonalRightBottom {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;
        /*
            1  2  3
            4  5  6
            7  8  9

            Output:
            1                 (0,0)                i: 0 -> 0,   j -> 0 -> 0   [0]
            2 4               (0,1), (1,0)         i: 0 -> 1,   j -> 1 -> 0   [1]
            3 5 7             (0,2), (1,1) (2,0)   i: 0 -> 2,   j -> 2 -> 0   [2]
            6 8               (1,2), (2,1)         i: 1 -> 2,   j -> 2 -> 1   [3]
            9                 (2,2)                i: 2 -> 2,   j -> 2 -> 2   [4]

            1   2   3  4
            5   6   7  8
            9   10  11 12

            Output:
            1                 (0,0)                      i: 0 -> 0,   j -> 0 -> 0   [0]
            2 5               (0,1), (1,0)               i: 0 -> 1,   j -> 1 -> 0   [1]
            3 6 9             (0,2), (1,1) (2,0)         i: 0 -> 2,   j -> 2 -> 0   [2]
            4 7 10            (0,3) (1,2), (2,1)         i: 0 -> 2,   j -> 3 -> 1   [3]
            8 11              (1,3) (2,2)                i: 1 -> 2,   j -> 3 -> 2   [4]
            12                (2,3)                      i: 2 -> 2,   j -> 3 -> 3   [5]

         */
        printDiagonal(matrix);
    }

    private static ArrayList<Integer> printDiagonal(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int iterations = rows + cols - 1;

        return null;
    }
}
