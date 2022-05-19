class TreeNode {
    // 节点的值
    int val;
    // 左节点的引用
    TreeNode left;
    // 右节点的引用
    TreeNode right;

    // 构造方法
    TreeNode(int x) {
        val = x;
    }
}
public class MergeTree {
    public static TreeNode mergeTrees(TreeNode node1, TreeNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        TreeNode merged = new TreeNode(node1.val + node2.val);
        merged.left = mergeTrees(node1.left, node2.left);
        merged.right = mergeTrees(node1.right, node2.right);
        return merged;
    }

    private static TreeNode initTree1() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.left.right.left = new TreeNode(7);

        node.right.left = new TreeNode(6);
        node.right.left.right = new TreeNode(8);
        return node;
    }

    private static TreeNode initTree2() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);

        node.left.right = new TreeNode(4);
        node.left.right.right = new TreeNode(7);

        node.right.left = new TreeNode(5);
        node.right.right = new TreeNode(6);
        return node;
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

    public static void main(String[] args) {
        TreeNode head1 = initTree1();
        System.out.println("第 1 棵二叉树：");
        preOrder(head1);

        TreeNode head2 = initTree2();
        System.out.println("\n第 2 棵二叉树：");
        preOrder(head2);

        TreeNode result = mergeTrees(head1,head2);
        System.out.println("\n合并后的二叉树：");
        preOrder(result);
    }
}