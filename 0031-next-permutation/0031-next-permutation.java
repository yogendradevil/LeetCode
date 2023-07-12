class Solution {
    public void nextPermutation(int[] nums) {
        // this problem can be solve by three steps 
        // 1. find the index i from where we can start changeing the elements 
        // 2. find the next greater then i and swap them
        // 3. now sort the array from i

        // step1
        int index = -1;
        for(int i = nums.length-1; i > 0; i--){
            if(nums[i] > nums[i-1]){
                index = i-1;
                break;
            }
        }

        // step2
        if(index != -1){
        for(int i = nums.length-1; i > index; i--){
            if(nums[i] > nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break; 
            }
        }
        }

        // step3
        int start = index+1;
        int end = nums.length-1;
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}