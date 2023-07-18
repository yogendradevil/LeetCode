class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0){
            return 0;
}
        int max = 1;
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++){
            if(!set.contains(nums[i]-1)){
                int temp = 1;
                int x = nums[i]+1;
                while(set.contains(x)){
                    temp++;
                    x++;
                }
                max = Math.max(max, temp);
            }
        }
        return max;
    }
}