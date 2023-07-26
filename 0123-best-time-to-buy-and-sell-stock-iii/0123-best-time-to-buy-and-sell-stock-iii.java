class Solution {
    public int maxProfit(int[] price) {
        int[] left = new int[price.length];
        int[] right = new int[price.length];
        int lmin = price[0];
        int rmax = price[price.length-1];
        left[0] = 0;
        int max = 0;
        for(int i = 1; i < price.length; i++){
            max = Math.max(max, price[i]-lmin);
            left[i] = max;
            if(price[i] < lmin){
                lmin = price[i];
            }
            System.out.print(left[i]+" ");
        }
        System.out.println();
        right[price.length-1] = 0;
        max = 0;
        for(int i = price.length-2; i >= 0; i--){
            max = Math.max(max, rmax-price[i]);
            right[i] = max;
            if(price[i] > rmax){
                rmax = price[i];
            }
            System.out.print(right[i]+" ");
        }
        max = 0;
        for(int i = 0; i < price.length; i++){
            if(i != 0){
            max = Math.max(max, left[i-1]+right[i]);
            }else{
                max = Math.max(max, right[i]);
            }
        }
        return max;
    }
}