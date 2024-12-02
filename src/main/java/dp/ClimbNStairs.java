package dp;

public class ClimbNStairs {
    public static int climbStairs(int n) {
        int[] memo = new int[n+1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        for(int i =3; i <= n; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(10));
    }
}
