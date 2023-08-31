class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return stairs(n, dp);
    }
    int stairs(int n, int[] dp){
        if(dp[n] == -1){
        if(n == 0 || n == 1){
            return 1;
        }
        int a = stairs(n-1, dp);
        int b = stairs(n-2, dp);
        dp[n]=a+b;
        }
        return dp[n];
    }

}