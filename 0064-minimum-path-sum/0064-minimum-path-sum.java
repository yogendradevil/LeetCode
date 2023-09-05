class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for(int[] temp : dp){
            Arrays.fill(temp, -1);
        }
        return helper(grid, grid.length-1, grid[0].length-1, dp);
    }
    int helper(int[][] arr, int i, int j, int[][] dp){
        if(i < 0 || j < 0){
            return 9999999;
        }
        if(i == 0 && j == 0){
            return arr[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up = arr[i][j]+helper(arr, i-1, j, dp);
        int left = arr[i][j]+helper(arr, i, j-1, dp);
        return dp[i][j] = Math.min(up, left);
    }
}