package dp;

public class UniquePaths {

    static Integer unique_paths(Integer n, Integer m) {
        int[][] table = new int[n][m];
        int modVal = (int) Math.pow(10, 9) + 7;
        for (int i = 0; i < n; i++) {
            table[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            table[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                table[i][j] = table[i][j-1] % modVal + table[i-1][j] %modVal;
            }
        }
        return table[n-1][m-1] %modVal;
    }

    public static void main(String[] args) {
        System.out.println(unique_paths(3,2));
    }
}
