class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] temp : dp){
            Arrays.fill(temp, -1);
        }
        return helper(triangle, 0, 0, dp);
    }
    int helper(List<List<Integer>> arr, int i, int j, int[][] dp){
        if(i == arr.size()-1){
            return arr.get(i).get(j);
        }
        if(dp[i][j] != -1){
            return  dp[i][j];
        }
        int down = arr.get(i).get(j) + helper(arr, i+1, j, dp);
        int right = arr.get(i).get(j) + helper(arr, i+1, j+1, dp);
        return dp[i][j] = Math.min(down, right);

    }
}