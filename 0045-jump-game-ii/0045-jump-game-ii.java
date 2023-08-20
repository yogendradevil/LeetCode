class Solution {
    public int jump(int[] nums) {
        int count = 0;
        int start  = 0; 
        int end = 0;
        while(end < nums.length-1){
            count++;
            int most = end;
            for(int i = start; i <= end; i++){
                if(nums[i]+i > most){
                    most = nums[i]+i;
                }
            } 
            start = end+1;
            end = most;
        }
        return count;
    }
}