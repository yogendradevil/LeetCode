class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] temp : dp){
            Arrays.fill(temp, -1);
        }
        int ans = helper(coins, amount, coins.length-1, dp);
        if(ans >= 1000000000){
            return -1;
        }else{
            return ans;
        }
    }
    int helper(int[] arr, int trr, int idx, int[][] dp){
        if(idx == 0){
            if(trr%arr[0] == 0){
                return trr/arr[0];
            }
            return 1000000000;
        }
        if(dp[idx][trr] != -1){
            return dp[idx][trr];
        }
        int notPick = 0 + helper(arr, trr, idx-1, dp);
        int pick = Integer.MAX_VALUE;
        if(arr[idx] <= trr){
            pick = 1 + helper(arr, trr-arr[idx], idx, dp);
        }
        return dp[idx][trr] = Math.min(notPick, pick);
    }
}