class Solution {
    public int rob(int[] nums) {
        if (nums.length==1) return nums[0];

        int n2[] = new int[nums.length];
        n2[1] = nums[1];
        
        if (nums[1] < nums[0]) nums[1] = nums[0];
        
        for (int i=2; i<nums.length; i++)
        {
            n2[i] = Math.max(nums[i]+n2[i-2], n2[i-1]);

            if (i+1 == nums.length)
            {
                nums[i] = Math.max(nums[i-2], nums[i-1]);
                return Math.max(n2[i], nums[i]);
            }
            
            nums[i] = Math.max(nums[i]+nums[i-2], nums[i-1]);
        }
        
        return nums[nums.length-1];
    }
}
