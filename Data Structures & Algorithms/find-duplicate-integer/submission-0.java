class Solution {
    public int findDuplicate(int[] nums) {
        // int max=0, sum=0;
        // for (int x : nums)
        // {
        //     sum += x;
        //     max = Math.max(x, max);
        // }
        // int ans = (int)Math.ceil(sum/(double)nums.length);

        // System.out.printf("DEBUG -> sum: %d | max: %d | len: %d | ans: %d", sum, max, nums.length, ans);

        // // ceil(sum/len) <= ans < max


        for (int i=0; i<nums.length; i++)
        {
            int cix = Math.abs(nums[i]);
            if (nums[cix] < 0) return cix;
            nums[cix] *= -1;
        }

        return 0;
    }
}
