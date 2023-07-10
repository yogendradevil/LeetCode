class Solution {
    public int largestRectangleArea(int[] arr) {
        int[] ns = new int[arr.length];
        int[] ps = new int[arr.length];

        nextSmaller(ns, arr);
        prevSmaller(ps, arr);

        int max = 0;
        
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, (arr[i]*(ns[i]-ps[i]-1)));
        }

        return max;

    }
    static void nextSmaller(int[] ns ,int[] arr){
        Stack<Integer> stack = new Stack<Integer>();
        ns[arr.length-1] = arr.length;
        stack.push(arr.length-1);
        for(int i = arr.length-2; i >= 0; i--){
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ns[i] = arr.length;
                System.out.println(ns[i]);
            }else{
                ns[i] = stack.peek();
                System.out.println(ns[i]);
            }
            stack.push(i);
        }
    }
    static void prevSmaller(int[] ps, int[] arr){
        Stack<Integer> stack = new Stack<Integer>();
        ps[0] = -1;
        stack.push(0);
        for(int i =1; i < arr.length; i++){
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ps[i] = -1;
                System.out.println(ps[i]);
            }else{
                ps[i] = stack.peek();
                System.out.println(ps[i]);
            }
            stack.push(i);
        }
    }
}

// class Solution {
//     public int largestRectangleArea(int[] arr) {
//         Stack<Integer> stack = new Stack<Integer>();
//         int curr = 0;
//         int res = 0;
//         for(int i = 0; i < arr.length; i++){
//             while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
//                 int temp = stack.pop();
//                 if(stack.isEmpty()){
//                     curr = arr[temp]*i;
//                 }else{
//                     curr = arr[temp]*(i - stack.peek() -1);
//                 }
//                 res = Math.max(curr, res);
//             }
//             stack.push(i);
//         }
//         while(!stack.isEmpty()){
//                 int temp = stack.pop();
//                 if(stack.isEmpty()){
//                     curr = arr[temp]*arr.length;
//                 }else{
//                     curr = arr[temp]*(arr.length - stack.peek() -1);
//                 }
//                 res = Math.max(curr, res);
//             }
//         return res;
//     }
// }