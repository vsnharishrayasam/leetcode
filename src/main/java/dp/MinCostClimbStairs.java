package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MinCostClimbStairs {

    static Integer min_cost_climbing_stairs(ArrayList<Integer> cost) {
        int n = cost.size();
        int[] dp = new int[n + 1];
        dp[0] = cost.get(0);
        dp[1] = cost.get(1);

        for (int i = 2; i <= n; i++) {
            int temp_cost  = i < n ? cost.get(i): 0;
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + temp_cost;
        }


        return dp[n];
    }


    public static void main(String[] args) {
        /*
        {
            "cost": [1, 1, 2]
        } Output: 1

        {
        "cost": [3, 4]
        } Output: 3







         */

        ArrayList<Integer> cost = new ArrayList<>(Arrays.asList(1,100,1,1,1,100,1,1,100,1));
        System.out.println(min_cost_climbing_stairs(cost));

    }
}
