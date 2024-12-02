package dp;

public class FibonacciNumber {
    static Integer find_fibonacci(Integer n) {
        if(n == 0 || n == 1) {return n;}
        int[] memo = new int[3];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;
        for(int i = 3; i <= n; i++) {
            memo[i%3] = memo[(i-1)%3] + memo[(i-2)%3];
        }
        return memo[n%3];
    }

    public static void main(String[] args) {
        System.out.println(find_fibonacci(10));
    }
}
