import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 * BINARY TREE POStORDER TRAVERSAL
 */

public class P0145 {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(list,root);
        return list;
    }

    public void postOrder(List<Integer> list, TreeNode root) {
        if(root != null) {
            postOrder(list,root.left);
            postOrder(list,root.right);
            list.add(root.val);
        }
    }
}

