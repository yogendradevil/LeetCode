class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        for(int[] temp : dp){
            Arrays.fill(temp, -1);
        }
        return helper(arr, n-1, m-1, dp);
    }
    int helper(int arr[][], int i, int j, int[][] dp){
        if(i < 0 || j < 0){
            return 0;
        }
        if(arr[i][j] == 1){
            return 0;
        }
        if(i == 0 && j == 0){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up = helper(arr, i, j-1, dp);
        int left = helper(arr, i-1, j, dp);
        return dp[i][j] = up+left;
    }
}