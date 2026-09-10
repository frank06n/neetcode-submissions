class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // int pre[] = new int[n];
        int out[] = new int[n];
        for (int i=0; i<n; i++) {
            if (i==0) {
                out[i] = 1;
                continue;
            }
            out[i] = out[i-1] * nums[i-1];
        }
        for (int i=n-1; i>=0; i--) {
            if (i==n-1) continue;
            out[i] *= nums[i+1];
            nums[i] *= nums[i+1];
        }
        return out;
    }
}  
