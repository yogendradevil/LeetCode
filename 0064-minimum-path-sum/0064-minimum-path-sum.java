class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        int sum = path(grid, dp, 0, 0);
        return sum;
    }
    static int path(int[][] arr, int[][] dp, int i, int j){
        if(i == arr.length-1 && j == arr[0].length-1){
            return arr[i][j];
        }
        if(i >= arr.length || j >= arr[0].length){
            return Integer.MAX_VALUE;
        }
        int sum = arr[i][j];
        int tempa = 0;
        int tempb = 0;
        if(i < arr.length-1 && j < arr[0].length-1 && dp[i][j+1] != -1){
            tempa = dp[i][j+1];
        }else{
            tempa = path(arr, dp, i, j+1);
        }
        if(i < dp.length-1 && j < dp[0].length-1 && dp[i+1][j] != -1){
            tempb = dp[i+1][j];
        }else{
            tempb = path(arr, dp, i+1, j);
        }
        sum += Math.min(tempa, tempb);
        dp[i][j] = sum;
        return sum;
    }
}