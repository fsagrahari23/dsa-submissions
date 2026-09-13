class Solution {
    public int maxProfit(int[] prices) {
        int max = Integer.MIN_VALUE;

        int cp = prices[0];

        for(int i=1;i<prices.length;i++){
            int profit = prices[i]-cp;
            cp = Math.min(cp,prices[i]);
            max = Math.max(profit,max);
        }

        return max<0?0:max;
    }
}
