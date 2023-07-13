class Solution {
    public int[][] merge(int[][] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr, (a,b) -> a[0] - b[0]);
        for(int i = 0; i < arr.length; i++){
            if(res.isEmpty() || res.get(res.size()-1).get(1) < arr[i][0]){
                res.add(Arrays.asList(arr[i][0], arr[i][1]));
                System.out.print("add");
            }else{
                res.get(res.size()-1).set(1, Math.max(res.get(res.size()-1).get(1), arr[i][1]));
                System.out.print("get");
            }
        }

        int[][] output = new int[res.size()][2];
        int i = 0;
        for(List<Integer> temp: res){
            output[i][0] = temp.get(0);
            output[i][1] = temp.get(1);
            i++;
        }
        return output;
    }
}