class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);

        return minCoins(coins, coins.length-1, amount);
    }

    int minCoins(int[] coins, int i, int amount)
    {
        if (amount==0) return 0;

        int t = amount/coins[i];
        if (amount%coins[i] == 0) return t;
        if (i==0) return -1;

        int min = -1;

        while (t>=0)
        {
            int left = amount - t*coins[i];
            int cc = minCoins(coins, i-1, left);
            if (cc!=-1)
            {
                cc += t;
                if (min==-1 || cc<min) min = cc;
            }
            t--;
        }

        return min;
    }
}
