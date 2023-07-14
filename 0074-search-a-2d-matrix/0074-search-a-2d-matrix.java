class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int n = arr.length;
        int m = arr[0].length;

        int s = 0;
        int e = (n*m)-1;

        while(s <= e){
            int mid = s + (e-s)/2;
            if(arr[mid/m][mid%m] == target){
                return true;
            }
            if(arr[mid/m][mid%m] > target){
                e = mid-1;
            }else{
                s = mid+1;
            }
        }
        return false;
    }
}