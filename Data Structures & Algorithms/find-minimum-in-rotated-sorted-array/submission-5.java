class Solution {
    public int findMin(int[] nums) {
        int l=0, r=nums.length-1;

        if (nums[l] < nums[r]) return nums[l];

        while (l<r)
        {
            int m = (l+r)/2;
            
            if (nums[m] > nums[r])
            {
                l=m+1;
            }
            else
            {
                if (m > 0 && nums[m-1] > nums[m]) return nums[m];
                r=m-1;
            }
        }
        return nums[l];
        // if (l < nums.length-1)
        // {
        //     return nums[l]<nums[l+1] ? nums[l] : nums[l+1];
        // }
        // else 
        // {
        //     return nums[l];
        // }
    }
}
