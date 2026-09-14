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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        if (root == null) return out;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            int last = -999; // will get reassigned since size>0
            for (int i=0; i<size; i++) {
                TreeNode x = queue.poll();
                last = x.val;
                if (x.left != null) queue.offer(x.left);
                if (x.right != null) queue.offer(x.right);
            }
            out.add(last);
        }
        return out;
    }
}
