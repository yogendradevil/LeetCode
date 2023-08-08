class Solution {
    public int search(int[] arr, int target) {
        int start=0;
        int end = arr.length-1;
        int max = -1;
        while(start <= end){
           int mid = start + (end - start) / 2;
            // 4 cases over here
            if (mid < end && arr[mid] > arr[mid + 1]) {
                max = mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                max = mid-1;
            }
            if (arr[mid] <= arr[start]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        int res = binary(arr, target, 0, max);
        if(res == -1){
            res = binary(arr, target, max+1, arr.length-1);
        }
        return res;
    }
    int binary(int[] a, int t, int s, int e) {
            while(s <= e){
            int mid = s+(e-s)/2;
                if(a[mid] == t){
                    return mid;
                }else if(a[mid] < t){
                    s = mid+1;
                }else{
                    e = mid-1;
                }
            }
            return -1;
        }
}