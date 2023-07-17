class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int c1 = 0;
        int c2 = 0;
        int v1 = Integer.MIN_VALUE;
        int v2 = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(c1 == 0 && v2 != nums[i]){
                c1 = 1;
                v1 = nums[i];
            }else if(c2 == 0 && v1 != nums[i]){
                c2 = 1;
                v2 = nums[i];
            }else if(v1 == nums[i]){
                c1++;
            }else if(v2 == nums[i]){
                c2++;
            }else{
                c1--;
                c2--;
            }
        }   

        c1 = 0; c2 =0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == v1){
                c1++;
            }else if(nums[i] == v2){
                c2++;
            }
        }

        ArrayList<Integer> arr = new ArrayList<Integer>();
        int min = (nums.length/3)+1;
        if(c1 >= min){
            arr.add(v1);
        }
        if(c2 >= min){
            arr.add(v2);
        }

        return arr;
    }
}