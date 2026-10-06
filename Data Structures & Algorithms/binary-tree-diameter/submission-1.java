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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return diameter;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftLength = depth(root.left);
        int rightLength = depth(root.right);

        diameter = Math.max(diameter, leftLength + rightLength);

        return 1 + Math.max(leftLength, rightLength);
    }
}
