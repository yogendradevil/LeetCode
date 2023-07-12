class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < prices[min]){
                min = i;
            }
            if(profit < (prices[i]-prices[min])){
                profit= prices[i]-prices[min];
            }
        }
        return profit;
    }
}