class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        int a = helper(cost, 0, dp);
        int b = helper(cost, 1, dp);
        return Math.min(a, b);
    }
    int helper(int[] arr, int idx, int[] dp){
        if(idx >= arr.length){
            return 0;
        }
        if(dp[idx] != -1){
            return dp[idx];
        }
        int oneStep = arr[idx] + helper(arr, idx+1, dp);
        int twoStep = arr[idx] + helper(arr, idx+2, dp);
        return dp[idx] = Math.min(oneStep, twoStep);
    }
}
