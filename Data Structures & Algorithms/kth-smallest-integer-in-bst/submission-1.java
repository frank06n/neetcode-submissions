/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
       int[] count = {0};
       return dfs(root, k, count);
    }

    int dfs(TreeNode root, int k, int[] count)
    {
        if (root == null) return -1;
        
        int val = dfs(root.left, k, count);
        if (count[0] == k) return val;

        count[0]++;
        if (count[0] == k) return root.val;

        return dfs(root.right, k, count);
    }
}