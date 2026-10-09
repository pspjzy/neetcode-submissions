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
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }
    public void dfs(TreeNode root, int depth, List<List<Integer>> res) {
        if(root == null){
            return;
        }
        if(depth == res.size()){
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);
        dfs(root.left, depth+1, res);
        dfs(root.right, depth+1, res);
    }
}
