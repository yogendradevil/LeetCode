// class Solution {
//     static public int max = 0;
//     public int constrainedSubsetSum(int[] nums, int k) {
//         int[] dp = new int[nums.length+1];
//         Arrays.fill(dp, -1);
//         max = nums[0];
//         int ans = helper(nums, 0, 0, k, dp);
//         if(ans == 0){
//             return max;
//         }
//         return ans;
//     }
//     int helper(int[] arr, int idx, int pre, int k, int[] dp){
//         if(idx >= arr.length){
//             return 0;
//         }
//         max = Math.max(max, arr[idx]);
//         if(idx-pre > k){
//             return 0;
//         }
//         // if(dp[idx] != -1){
//         //     return dp[idx];
//         // }
//         int pick = arr[idx]+helper(arr, idx+1, idx, k, dp);
//         int notPick = 0+helper(arr, idx+1, pre, k, dp);
//         int res = Math.max(pick, notPick);
//         return dp[idx]=res;
//     }
// }
class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int maxSum = nums[0];
        Deque<Integer> maxSumQueue = new ArrayDeque<>();
        
        for (int i = 0; i < nums.length; ++i) {
            nums[i] += !maxSumQueue.isEmpty() ? maxSumQueue.peek() : 0;
            maxSum = Math.max(maxSum, nums[i]);
            
            while (!maxSumQueue.isEmpty() && nums[i] > maxSumQueue.peekLast()) {
                maxSumQueue.pollLast();
            }
            
            if (nums[i] > 0) {
                maxSumQueue.offer(nums[i]);
            }
            
            if (i >= k && !maxSumQueue.isEmpty() && maxSumQueue.peek() == nums[i - k]) {
                maxSumQueue.poll();
            }
        }
        
        return maxSum;
    }
}