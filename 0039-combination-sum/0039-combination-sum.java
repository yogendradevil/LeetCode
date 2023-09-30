class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, candidates.length-1, res, new ArrayList<>());
        return res;
    }
    void helper(int[] arr, int curr, int idx, List<List<Integer>> res, List<Integer> ds){
        if(curr == 0){
            res.add(new ArrayList<>(ds));
            return;
        }
        if(idx < 0 || curr < 0){
            return;
        }
        if(arr[idx] <= curr){
            ds.add(arr[idx]);
            helper(arr, curr-arr[idx], idx, res, ds);
            ds.remove(ds.size()-1);
        }
        helper(arr, curr, idx-1, res, ds);
    }
}