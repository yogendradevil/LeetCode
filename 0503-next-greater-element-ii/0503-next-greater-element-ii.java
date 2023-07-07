class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] arr = new int[nums.length];

        for(int i = nums.length-1; i >= 0; i--){
            stack.push(nums[i]);
        }

        for(int i = nums.length-1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                arr[i] = -1;
            }else{
            arr[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return arr;
    }
}