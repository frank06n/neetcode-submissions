class Solution {
    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];

        int nx_a = 0, nx_b = nums[1];
        
        if (nums[1] < nums[0]) nums[1] = nums[0];
        
        for (int i=2; i<nums.length; i++)
        {
            int nx_c = Math.max(nums[i]+nx_a, nx_b);
            nx_a = nx_b;
            nx_b = nx_c;

            if (i+1 == nums.length)
            {
                nums[i] = Math.max(nums[i-2], nums[i-1]);
                return Math.max(nx_c, nums[i]);
            }
            
            nums[i] = Math.max(nums[i]+nums[i-2], nums[i-1]);
        }

        return nums[nums.length-1]; // for cases len <= 2
    }
}
