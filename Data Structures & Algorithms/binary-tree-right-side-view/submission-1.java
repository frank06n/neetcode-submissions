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
    List<Integer> out;
    public List<Integer> rightSideView(TreeNode root) {
        out = new ArrayList();
        dfs(root, 0);
        return out;
    }

    void dfs(TreeNode root, int d) {
        if (root == null) return;

        if (out.size() <= d)
        {
            out.add(root.val);
        }

        dfs(root.right, d+1);
        dfs(root.left, d+1);
    }
}
