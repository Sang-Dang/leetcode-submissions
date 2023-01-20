import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * BINARY TREE PREORDER TRAVERSAL
 */

public class P0144 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) {this(val,null,null);}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(list,root);
        return list;
    }

    public void preOrder(List<Integer> list, TreeNode root) {
        if(root != null) {
            list.add(root.val);
            preOrder(list,root.left);
            preOrder(list,root.right);
        }
    }
}
