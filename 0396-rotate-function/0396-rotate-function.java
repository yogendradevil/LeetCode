// class Solution {
//     public int maxRotateFunction(int[] nums) {
//         int max = Integer.MIN_VALUE;
//         for(int i = 0; i < nums.length; i++){
//             int[] arr = nums.clone();
//             max = Math.max(max, f(arr, i));
//         }
//         return max;
//     }
//     int f(int[] arr, int n){
//         int i = arr.length-n; 
//         int j = arr.length-1;
//         while(i < j){
//             int temp = arr[i];
//             arr[i] = arr[j];
//             arr[j] = temp;
//             j--;
//             i++;
//         }
//         i = 0;
//         j = arr.length-n-1;
//         while(i < j){
//             int temp = arr[i];
//             arr[i] = arr[j];
//             arr[j] = temp;
//             j--;
//             i++;
//         }
//         i = 0; 
//         j = arr.length-1;
//         while(i < j){
//             int temp = arr[i];
//             arr[i] = arr[j];
//             arr[j] = temp;
//             j--;
//             i++;
//         }

//         int sum = 0;
//         for(i = 0; i < arr.length; i++){
//             sum += (i*arr[i]);
//         }
//         return sum;
//     }
// }

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int iterationSum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            iterationSum += i * nums[i];
        }

        int max = iterationSum;

        for (int i = 1; i < n; i++) {
            iterationSum += sum - n * nums[n - i];
            max = Math.max(max, iterationSum);
        }

        return max;
    }
}