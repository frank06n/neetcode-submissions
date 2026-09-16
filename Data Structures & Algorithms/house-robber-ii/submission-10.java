class Solution {
    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];

        int a,b,p,q;

        a = nums[0];
        b = Math.max(nums[0], nums[1]);
        p = 0;
        q = nums[1];
        
        for (int i=2; i<nums.length; i++)
        {
            int r = Math.max(nums[i]+p, q);
            p = q;
            q = r;

            if (i+1 == nums.length)
                return Math.max(r, Math.max(a, b));

            
            int c = Math.max(nums[i]+a, b);
            a = b;
            b = c;
        }

        return b;
    }
}
