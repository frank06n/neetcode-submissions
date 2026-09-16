class Solution {
    List<List<Integer>> out;
    List<Integer> curr;
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        out = new ArrayList<>();
        curr = new ArrayList<>();

        dfs();

        return out;
    }

    void dfs() {
        if (curr.size() == nums.length) {
            out.add(new ArrayList<>(curr));
            return;
        }

        for (int i=0; i<nums.length; i++)
        {
            if (nums[i] == -999) continue;

            curr.add(nums[i]);
            int temp = nums[i];
            nums[i] = -999;

            

            dfs();
            curr.remove(curr.size()-1);
            nums[i] = temp;
        }
    }
}
