class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
      return helper(nums, target, 0, dp);
    }
    int helper(int[] arr, int target, int idx, int[] dp){
        if(idx == arr.length){
        if(target == 0){
          return 1;
        }
          return 0;
        }
        // if(dp[idx] != -1){
        //     return dp[idx];
        // }
        int a = helper(arr, target-arr[idx], idx+1, dp);
        int b = helper(arr, target+arr[idx], idx+1, dp);

        return dp[idx] = a+b;
    }
}