class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length == 1)
        {
            return (int)Math.ceil(piles[0]/(double)h);
        }
        int lt = 1, rt = Integer.MIN_VALUE;
        for (int n : piles)
        {
            if (n>rt) rt = n;
        }

        int best_k = rt;

        while (lt<=rt)
        {
            int k = (lt+rt)/2;
            int x = 0;
            for (int n : piles)
            {
                x += n/k;
                if (n%k != 0) x += 1;
            }
            // System.out.printf("lt: %d, rt: %d; k: %d, x: %d\n", lt, rt, k, x);

            if (x<=h)
            {
                best_k = Math.min(k, best_k);
                rt = k-1;
            }
            else
            {
                lt = k+1;
            }
        }
        return best_k;
    }
}
