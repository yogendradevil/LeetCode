// Brute Force O(n^2)
/*
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int count =0;
        int[] result = new int[nums.length];
        for (int i =0; i< nums.length; i++){
            for(int j =0; j < nums.length; j++){
                if(nums[i] > nums[j]){
                    count +=1;
                }
            }
            result[i] = count;
            count = 0;
        }
        return result;
    }
}
*/

// optimal solution O(n)
// Space complexity O(102)

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] fre = new int[102];

        for(int i = 0; i < nums.length; i++){
            fre[nums[i]]++;
        }

        for(int i = 1; i < 102; i++){
            fre[i] = fre[i]+fre[i-1];
        }

        int[] arr = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                arr[i] = 0;
            }else{
                arr[i] = fre[nums[i]-1];
            }
        }

        return arr;
    }
}