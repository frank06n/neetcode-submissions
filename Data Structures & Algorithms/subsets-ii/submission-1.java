class Solution {
    List<List<Integer>> out;
    List<Integer> curr;
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        out = new ArrayList<>();
        curr = new ArrayList<>();

        Arrays.sort(nums);
        this.nums = nums;

        dfs(0, -999);
        return out;
    }
    void dfs(int i, int last)
    {
        if (i == nums.length)
        {
            out.add(new ArrayList<>(curr));
            return;
        }

        // Include nums[i]
        curr.add(nums[i]);
        dfs(i+1, nums[i]);
        curr.remove(curr.size() - 1);

        // If nums[i] not used in curr
        if (nums[i] != last)
        {
            // Exclude nums[i]
            dfs(i+1, last);
        }
    }
}
/*
Reason for skipping nums[i] exclude case if its value is already in curr is.
Let x = nums[i]

# CASE 0: x NOT included previously
check both cases x included, excluded,
so subsets added: [_, x, ...], [_, _, ...]

# CASE 1: x included previously
check x included case only,
so subsets added: [x, x, ...]
subset skipped [x, _, ...], since a its duplicate of [_, x, ...]

Checking with x==last suffices as x included previously,
since nums is sorted, so if duplicate x exists it has to be == last.
*/
