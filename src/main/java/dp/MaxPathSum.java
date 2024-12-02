package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxPathSum {

    static Integer maximum_path_sum(ArrayList<ArrayList<Integer>> grid) {
        if(grid == null || grid.isEmpty()) return 0;
        int rows = grid.size();
        int cols = grid.get(0).size();
        int[][] dp = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            dp[i][0] = grid.get(i).get(0);
            if(i > 0) {
                dp[i][0] += dp[i-1][0];
            }
        }
        for(int j = 1; j < cols; j++) {
            dp[0][j] = grid.get(0).get(j);
                dp[0][j] += dp[0][j-1];
        }

        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < cols; j++) {
                dp[i][j] = grid.get(i).get(j) + Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }


        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        /*
        {
        "grid": [
        [4, 5, 8],
        [3, 6, 4],
        [2, 4, 7]
        ]
        }
        Output: 28


        {
        "grid": [
        [1, -4, 3],
        [4, -2, 2]
        ]
        }
        output: 5
         */
        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
        grid.add(new ArrayList<>(Arrays.asList(4,5,8)));
        grid.add(new ArrayList<>(Arrays.asList(3,6,4)));
        grid.add(new ArrayList<>(Arrays.asList(2,4,7)));
        System.out.println(maximum_path_sum(grid));

        ArrayList<ArrayList<Integer>> grid1 = new ArrayList<>();
        grid1.add(new ArrayList<>(Arrays.asList(1,-4,3)));
        grid1.add(new ArrayList<>(Arrays.asList(4,-2,2)));
        System.out.println(maximum_path_sum(grid1));



        }




}
