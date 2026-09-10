class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;
        while (l<=r)
        {
            int i = (l+r)/2;
            if (target == nums[i]) return i;
            else if (target < nums[i]) r = i-1;
            else l = i+1; 
        }
        return -1;
    }
}
