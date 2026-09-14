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
       Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       dfs(root, k, pq);
       return pq.peek();
    }

    void dfs(TreeNode root, int k, Queue<Integer> pq)
    {
        if (root == null) return;
        dfs(root.left, k, pq);

        if (pq.size() == k) return;
        pq.offer(root.val);
        if (pq.size() == k) return;
        dfs(root.right, k, pq);
    }
}