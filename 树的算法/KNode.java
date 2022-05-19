import java.util.Stack;

public class KNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        int result = KthNode(root, 3);
        System.out.print("前序遍历：");
        preOrder(root);
        System.out.println("\n第3小的节点：" + result);
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

    public static int KthNode(TreeNode proot, int k) {
        if (proot == null) return -1;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(proot);
        TreeNode node = proot;
        int i = 0;
        while (!stack.isEmpty()) {
            //左子树
            while (node.left != null) {
                stack.push(node.left);
                node = node.left;
            }
            i++;
            if (i == k) {
                return stack.pop().val;
            }
            TreeNode temp = stack.pop();
            // 右子树
            if (temp.right != null) {
                stack.push(temp.right);
                node = temp.right;
            }
        }
        return -1;
    }
}