class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;

        while (l<=r)
        {
            int m = (l+r)/2;

            System.out.printf("L[%d] = %d | M[%d] = %d | R[%d] = %d\n", l, nums[l], m, nums[m], r, nums[r]);

            if (target < nums[m])
            {
                System.out.println("  t < n[m]");
                if (target < nums[l] && nums[l] <= nums[m]) l = m+1;
                else r = m-1;
            }
            else if (target > nums[m])
            {
                System.out.println("  t > n[m]");
                if (target > nums[r] && nums[r] >= nums[m]) r = m-1;
                else l = m+1;
            }
            else // if found
            {
                return m;
            }
        }

        return -1;
    }
}
