public class SearchTree {
    // 上一个节点
    static long pre = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode root = initTree();
        System.out.print("前序遍历：");
        preOrder(root);
        System.out.println("\n是否为二叉搜索树：" + isValidBST(root));
    }
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 左子树
        if (!isValidBST(root.left)) {
            return false;
        }
        // 当前节点
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        // 右子树
        return isValidBST(root.right);
    }

    // 构造初始化树
    static public TreeNode initTree() {
        TreeNode treeNode = new TreeNode(7);
        treeNode.left = new TreeNode(5);
        treeNode.right = new TreeNode(9);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(6);

        treeNode.right.left = new TreeNode(8);
        treeNode.right.right = new TreeNode(11);
        return treeNode;
    }

    // 前序遍历
    static public void preOrder(TreeNode root) {
        if (root != null) {
            // 打印根节点
            System.out.print(root.val + " ");
            // 访问左子树
            preOrder(root.left);
            // 访问右子树
            preOrder(root.right);
        }
    }
}