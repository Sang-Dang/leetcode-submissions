import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/increasing-order-search-tree/
 */

public class P0897 {
    public static class TreeNode {
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

    public void noobSolution() {
        TreeNode t0 = new TreeNode(3);
        TreeNode t1 = new TreeNode(4, t0, null);
        TreeNode t2 = new TreeNode(1);
        TreeNode root = new TreeNode(2, t2, t1);
        TreeNode solution = increasingBST(root);
        while(solution != null) {
            System.out.println(solution.val);
            solution = solution.right;
        }
    }

    private List<TreeNode> list;

    public TreeNode increasingBST(TreeNode root) {
        list = new ArrayList<>();
        inOrder(root);
        int i;
        for (i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i + 1);
            list.get(i).left = null;
        }
        list.get(i).left = null;
        return list.get(0);
    }

    private void inOrder(TreeNode start) {
        if (start != null) {
            inOrder(start.left);
            list.add(start);
            inOrder(start.right);
        }
    }

    public TreeNode solution2(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        while(!s.isEmpty()) {
            while(s.peek().left != null && !result.contains(s.peek().left)) {
                s.add(s.peek().left);
            } 
            TreeNode current = s.pop();
            result.add(current);
            result.get(result.size() - 1).left = null;
            if(result.size() - 2 >= 0) {
                result.get(result.size() - 2).right = result.get(result.size() - 1);
            } 

            if(current.right != null) {
                s.add(current.right);
            }
        }
        return result.get(0);
    }

    public static void main(String[] args) {
        TreeNode t0 = new TreeNode(3);
        TreeNode t1 = new TreeNode(4, t0, null);
        TreeNode t2 = new TreeNode(1);
        TreeNode root = new TreeNode(2, t2, t1);
        TreeNode solution = new P0897().solution2(root);
        while(solution != null) {
            System.out.println(solution.val);
            solution = solution.right;
        }
    }
}
