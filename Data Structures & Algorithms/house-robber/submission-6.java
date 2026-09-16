class Solution {
    public int rob(int[] nums) {
        int i;
        for (i=0; i<nums.length; i++)
        {
            if (i==0) continue;
            if (i==1) {
                if (nums[0] > nums[1]) nums[1] = nums[0]; 
                continue;
            }
            nums[i] = Math.max(nums[i]+nums[i-2], nums[i-1]);
        }

        return nums[i-1];
    }
}
