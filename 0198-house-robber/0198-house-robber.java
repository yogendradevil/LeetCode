class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return helper(nums, nums.length-1, dp);
    }
    int helper(int[] arr, int n, int[] dp){
        if(n < 0){
            return 0;
        }
        if(dp[n] == -1){
        int pick = arr[n]+helper(arr, n-2, dp);
        int nopick = helper(arr,n-1, dp);
        dp[n] = Math.max(pick ,nopick);
        }
        return dp[n];
    }
}