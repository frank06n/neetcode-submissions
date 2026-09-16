class Solution {
    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];

        int nx_a = 0, nx_b = nums[1];
        int n_a = nums[0], n_b = nums[1];
        
        if (n_a > n_b) n_b = n_a;
        int max = n_b;
        
        for (int i=2; i<nums.length; i++)
        {
            int nx_c = Math.max(nums[i]+nx_a, nx_b);
            nx_a = nx_b;
            nx_b = nx_c;

            if (i+1 == nums.length)
            {
                return Math.max(nx_c, Math.max(n_a, n_b));
            }
            
            int n_c = Math.max(nums[i]+n_a, n_b);
            n_a = n_b;
            n_b = n_c;
        }

        return n_b; // for cases len <= 2
    }
}
