class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length-1;
        List<List<Integer>> arr = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int j = i+1;
            int k = n;
            while( j < k ){
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> res = new ArrayList<Integer>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[k]);
                    arr.add(res);
                    k--;
                    j++;
                    while(j < k && nums[k] == nums[k+1]){
                        k--;
                    }
                    while(j < k && nums[j] == nums[j-1]){
                        j++;
                    }
                }else if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        return arr;
    }
}