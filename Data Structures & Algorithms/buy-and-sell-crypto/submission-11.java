class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int low=0;
        int high=1;
        int maxprofit = Integer.MIN_VALUE;
        int currentprofit = 0;
        while(high<n)
        {
            if(prices[low]<prices[high])
            {
                currentprofit = prices[high] - prices[low];
                maxprofit = Math.max(currentprofit,maxprofit);
            }
            else
                low = high;
            high++;
        }
        if(maxprofit == Integer.MIN_VALUE)
            return 0;
        else
            return maxprofit;

    }
}
