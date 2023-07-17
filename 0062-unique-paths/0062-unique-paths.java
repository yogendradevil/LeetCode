class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return path(m, n, 0, 0, dp);
    }
    int path(int m, int n, int i, int j, int[][] dp){
        if(i >= m || j >= n){
            return 0;
        }
        if(i == m-1 && j == n-1){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int a = path(m, n, i, j+1, dp);
        int b = path(m, n, i+1, j, dp);
        dp[i][j] = a+b;
        return a+b;
    }
}