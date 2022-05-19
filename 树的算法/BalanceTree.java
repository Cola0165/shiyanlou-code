public class BalanceTree {
    // 测试代码
    public static void main(String[] args) {
        // 构造二叉树
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);

        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        boolean result = isBalance(treeNode);
        System.out.println(result);
    }

    public static boolean isBalance(TreeNode root) {
        // 空树
        if (root == null) {
            return true;
        }
        return getHeight(root) != -1;
    }

    public static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 左子树的高度
        int left = getHeight(root.left);
        if (left < 0) {
            return -1;
        }
        // 右子树的高度
        int right = getHeight(root.right);
        if (right < 0) {
            return -1;
        }
        return Math.abs(left - right) > 1 ? -1 : 1 + Math.max(left, right);
    }
}