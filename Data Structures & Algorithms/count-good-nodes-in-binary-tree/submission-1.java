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
    public int goodNodes(TreeNode root) {
        int[] count = {0};
        dfs(root, root.val, count);
        return count[0];
    }

    void dfs(TreeNode node, int max, int[] count)
    {
        if (node.val >= max) {
            count[0]++;
            max = node.val;
        }
        if (node.left != null) dfs(node.left, max, count);
        if (node.right != null) dfs(node.right, max, count);
    }
}
