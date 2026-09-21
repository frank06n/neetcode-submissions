class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1) return nums[0];

        int smax = nums[0];
        int max = nums[0];
        int min = nums[0];

        for (int i=1; i<nums.length; i++)
        {
            int wmax = nums[i]*max, wmin = nums[i]*min;
            
            max = Math.max(nums[i], Math.max(wmax, wmin));
            min = Math.min(nums[i], Math.min(wmax, wmin));

            smax = Math.max(max, smax);
        }

        return smax;
    }
}
