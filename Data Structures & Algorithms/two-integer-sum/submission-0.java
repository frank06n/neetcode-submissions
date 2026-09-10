class Solution {
    public int[] twoSum(int[] nums, int target) {
        int nums2[] = new int[nums.length];
        for (int i=0; i<nums.length; i++) nums2[i] = nums[i];
        Arrays.sort(nums2);
        int i=0, j=nums2.length-1;
        while (true) {
            int sum = nums2[i] + nums2[j];
            if (sum > target) {
                j--;
            }
            else if (sum < target) {
                i++;
            }
            else {
                break;
            }
        }
        int out[] = new int[]{-1,-1};
        for (int k=0; k<nums.length; k++) {
            if (i != -1 && nums2[i] == nums[k]) {
                out[out[0] == -1 ? 0 : 1] = k;
                i = -1;
            }
            else if (j != -1 && nums2[j] == nums[k]) {
                out[out[0] == -1 ? 0 : 1] = k;
                j = -1;
            }
            if (out[1] != -1) break;
        }
        return out;
    }
}
