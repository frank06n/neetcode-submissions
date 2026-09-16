class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==1) return nums[0];
        if (n==2) return Math.max(nums[0], nums[1]);
        for (int i=0; i<n; i++)
        {
            if (i==0) continue;
            if (i==1) {
                if (nums[0] > nums[1]) nums[1] = nums[0]; 
                continue;
            }
            nums[i] = Math.max(nums[i]+nums[i-2], nums[i-1]);
        }

        return nums[n-1];
    }
}
