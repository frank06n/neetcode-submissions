class Solution {
    public int maxProfit(int[] prices) {
        int b=0;
        int s=0;
        int p=0;// max profit
        for (int i=0; i<prices.length;i++) {
            if (prices[i] < prices[b]) {
                b=s=i;
            }
            else if (prices[i] > prices[s]) {
                s=i;
                int prof =  prices[s] - prices[b];
                if (prof > p) p = prof;
            }
        }
        return p;
    }
}
