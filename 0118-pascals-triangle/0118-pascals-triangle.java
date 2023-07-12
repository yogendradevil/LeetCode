class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> arr = new ArrayList<List<Integer>>();        
        for(int i = 1; i <= n; i++){
            arr.add(genRow(i));
        }
        return arr;
    }
    ArrayList<Integer> genRow(int n){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        int ans = 1;
        for(int i = 1; i < n; i++){
            ans *= (n-i);
            ans = ans/i;
            arr.add(ans);
        }
        return arr;
    }
}