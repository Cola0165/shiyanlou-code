public class MinGap {
    static TreeNode prev = null;
    static int minGap = Integer.MAX_VALUE;

    public static int minGap(TreeNode root) {
        midOrder(root);
        return minGap;
    }

    public static void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(root.left);
        System.out.print(root.val + " ");
        if (prev != null) {
            minGap = Math.min(minGap, root.val - prev.val);
        }
        prev = root;
        midOrder(root.right);
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

    private static TreeNode initTree() {
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(5);
        node.right = new TreeNode(11);

        node.left.left = new TreeNode(2);
        node.left.right = new TreeNode(7);

        node.right.left = new TreeNode(9);
        node.right.right = new TreeNode(15);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = initTree();
        System.out.print("前序遍历：");
        preOrder(root);
        System.out.print("\n中序遍历：");
        int gap = minGap(root);
        System.out.println("\n节点最小差值：" + gap);
    }
}