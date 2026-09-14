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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        if (root == null) return out;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> sub = new ArrayList<>(); 
            for (int i=0; i<size; i++)
            {
                TreeNode x = queue.poll();
                sub.add(x.val);
                if (x.left != null) queue.add(x.left);
                if (x.right != null) queue.add(x.right);
            }
            out.add(sub);
        }

        return out;
    }
}
