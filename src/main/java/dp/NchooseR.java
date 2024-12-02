package dp;

public class NchooseR {

    static Integer ncr(Integer n, Integer r) {
        if (r > n) return 0;
        int modVal = (int) Math.pow(10, 9) + 7;
        int[][] table = new int[n + 1][r + 1];
        for(int i = 0; i<=n; i++) {
            table[i][0] = 1;
        }
        for(int i = 0; i<=r; i++) {
            table[i][i] = 1;
        }
        for(int i = 1; i<=n; i++) {
            for(int j = 1; j<=r; j++) {
                table[i][j] = table[i-1][j-1] % modVal + table[i-1][j] % modVal;
            }
        }
        return table[n][r] % modVal;

    }


    public static void main(String[] args) {
        System.out.println(ncr(200, 100));
    }




}
