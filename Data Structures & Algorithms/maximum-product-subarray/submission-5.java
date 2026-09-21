class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int smax = nums[0];
        int max = nums[0];
        int min = nums[0];

        for (int i=1; i<nums.length; i++)
        {
            int _x = max, _n = min;
            
            max = Math.max(nums[i], Math.max(_x*nums[i], _n*nums[i]));
            min = Math.min(nums[i], Math.min(_x*nums[i], _n*nums[i]));

            smax = Math.max(max, smax);
        }

        return smax;
    }
}
