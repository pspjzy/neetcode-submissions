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

public class Codec {
    private int index = 0;

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeDFS(root, sb);
        return sb.toString();
    }

    private void serializeDFS(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("N,");
            return;
        }

        sb.append(node.val).append(",");
        serializeDFS(node.left, sb);
        serializeDFS(node.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        index = 0;
        return deserializeDFS(values);
    }

    private TreeNode deserializeDFS(String[] values) {
        String val = values[index++];

        if (val.equals("N")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(val));

        root.left = deserializeDFS(values);
        root.right = deserializeDFS(values);

        return root;
    }
}