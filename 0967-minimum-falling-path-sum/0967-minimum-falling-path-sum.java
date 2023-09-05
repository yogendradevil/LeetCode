class Solution {
    public int minFallingPathSum(int[][] matrix) {

        // DP
        Integer[][] dp = new Integer[matrix.length][matrix[0].length];

        // finding starting point
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < matrix[0].length; i++){
            int temp = helper(matrix, 0, i, dp);
            res = Math.min(res, temp);
        }
        return res;
    }

    int helper(int[][] arr, int i, int j, Integer[][] dp){
        if(j < 0 || j > arr[0].length-1){
            return 9999999;
        }
        if(i == arr.length-1){
            return arr[i][j];
        }
        if(dp[i][j] != null){
            return dp[i][j];
        }
        int a = arr[i][j] + helper(arr, i+1, j-1, dp);
        int b = arr[i][j] + helper(arr, i+1, j, dp);
        int c = arr[i][j] + helper(arr, i+1, j+1, dp);
        return dp[i][j] = Math.min(Math.min(a , b), c);
    }
}