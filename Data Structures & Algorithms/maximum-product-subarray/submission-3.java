class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int allmax = nums[0]; // max of all
        
        int fwn = 0; // first with negative
        int max = 0; // max of curr
        int mxwn = 0; // max with negative
        boolean encn = false; // encountered negative

        for (int i=0; i<nums.length; i++)
        {
            if (nums[i] == 0)
            {
                fwn=max=mxwn=0;
                encn = false;
                if (allmax < 0) allmax = 0;
            }
            else if (nums[i] < 0)
            {
                mxwn = (mxwn == 0) ? nums[i] : (mxwn*nums[i]);
                max = (mxwn > 0) ? mxwn : 0;

                if (mxwn > allmax) allmax = mxwn;
                

                if (!encn)
                {
                    encn = true;
                    fwn = mxwn;
                }
                else if (mxwn < 0 && mxwn/fwn > allmax) 
                {
                    allmax = mxwn/fwn;
                }
            }
            else
            {
                mxwn = (mxwn == 0) ? nums[i] : (mxwn*nums[i]);
                max = (max == 0) ? nums[i] : (max*nums[i]);

                if (max > allmax) allmax = max;
                if (mxwn < 0 && encn && mxwn/fwn > allmax) allmax = mxwn/fwn;
            }
            // System.out.printf("n: %d, max: %d, mxwn: %d, fwn: %d, allmax: %d\n", nums[i], max, mxwn, fwn, allmax);
        }

        return allmax;
    }
}
