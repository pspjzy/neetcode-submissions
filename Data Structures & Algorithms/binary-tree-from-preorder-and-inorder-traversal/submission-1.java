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
    int preIndex = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // 记录每个值在 inorder 中的位置
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder, 0, inorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int left, int right) {

        if (left > right) {
            return null;
        }

        // Preorder 下一个值就是当前子树的 root
        int val = preorder[preIndex++];
        TreeNode root = new TreeNode(val);

        // 找到 root 在 inorder 中的位置
        int mid = map.get(val);

        // 构建左子树
        root.left = dfs(preorder, left, mid - 1);

        // 构建右子树
        root.right = dfs(preorder, mid + 1, right);

        return root;
    }
}
