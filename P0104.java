/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * MAXIMUM DEPTH OF BINARY TREE
 */

public class P0104 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int maxDepth(TreeNode root) {
        int height = 0;
        TreeNode[] children = {root.left, root.right};
        for(TreeNode i: children) {
            height = Math.max(height,1 + maxDepth(i));
        }
        return height;
    }
}
