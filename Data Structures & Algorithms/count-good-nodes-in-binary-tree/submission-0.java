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
        return dfs(root, Integer.MIN_VALUE);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        int count = 0;

        // 当前节点是否是 Good Node
        if (node.val >= maxSoFar) {
            count = 1;
        }

        // 更新路径最大值
        int newMax = Math.max(maxSoFar, node.val);

        // 递归左右子树
        int left = dfs(node.left, newMax);
        int right = dfs(node.right, newMax);

        return count + left + right;
    }
}
