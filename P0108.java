public class P0108 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {}
        public TreeNode(int data) {
            this(data,null,null);
        }
        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.val = data;
            this.left = left;
            this.right = right;
        }
    }

    TreeNode root;

    public P0108() {
        root = null;
    }

    public void insert(int node) {
        insertRecursive(new TreeNode(node), root);
    }

    private void insertRecursive(TreeNode node, TreeNode start) {
        if (root == null) {
            root = node;
            return;
        }
        if (node.val > start.val) {
            if (start.right == null) {
                start.right = node;
                return;
            }
            insertRecursive(node, start.right);
        } else if (node.val < start.val) {
            if (start.left == null) {
                start.left = node;
                return;
            }
            insertRecursive(node, start.left);
        } else {
            System.out.println("That number is already there idiot. ");
            return;
        }
    }

    public void insertFromArray(int[] array, int start, int end) {
        if(start > end)
            return;
        else if(start == end) {
            insert(array[start]);
            return;
        }
        int middle = start + ((end - start)/2);
        insert(array[middle]);
        insertFromArray(array,start,middle - 1);
        insertFromArray(array,middle + 1, end);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        P0108 temp = new P0108();
        temp.insertFromArray(nums, 0, nums.length);
        return temp.root;
    }
}
