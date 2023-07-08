class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int curr = 0;
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                int temp = stack.pop();
                if(stack.isEmpty()){
                    curr = arr[temp]*i;
                }else{
                    curr = arr[temp]*(i - stack.peek() -1);
                }
                res = Math.max(curr, res);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
                int temp = stack.pop();
                if(stack.isEmpty()){
                    curr = arr[temp]*arr.length;
                }else{
                    curr = arr[temp]*(arr.length - stack.peek() -1);
                }
                res = Math.max(curr, res);
            }
        return res;
    }
}