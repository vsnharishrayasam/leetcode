package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MinimumCoinsChange {

    static Integer minimum_coins(ArrayList<Integer> coins, Integer value) {
        if (coins == null || coins.isEmpty()) return -1;
        int[] dp = new int[value + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0) {
                    min = Math.min(min, dp[i - coin] + 1);
                }
            }
            dp[i] = min;
        }

        return (dp[value] == Integer.MAX_VALUE || dp[value] < 0) ? -1 : dp[value];


    }


    public static void main(String[] args) {
        /*
        {
        "coins": [1, 3, 5],
        "value": 9
        } Output:3

         */
        ArrayList<Integer> coins = new ArrayList<>(Arrays.asList(1));
        System.out.println(minimum_coins(coins, 0));

    }
}
