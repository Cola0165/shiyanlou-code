import java.util.Stack;

public class MirrorTree {

  public static void main(String[] args) {
    TreeNode root = initTree();
    mirror(root);
    preOrder(root);
  }

  public static void mirror(TreeNode root) {
    if (root == null) {
      return;
    }
    Stack<TreeNode> stack = new Stack<>();
    // 先把根节点加入堆栈
    stack.push(root);
    // 判断根节点是否为空
    while (!stack.isEmpty()) {
      // 弹出第一个节点
      TreeNode node = stack.pop();
      // 保存左子树
      TreeNode tempNode = node.left;
      // 将左子树换成右子树
      node.left = node.right;
      // 右子树换成以前的左子树
      node.right = tempNode;
      // 添加左节点
      if (node.left != null) {
        stack.push(node.left);
      }
      // 添加右节点到堆栈
      if (node.right != null) {
        stack.push(node.right);
      }
    }
  }

  // 初始化树结构
  public static TreeNode initTree() {
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(6);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(7);
    root.right.left = new TreeNode(9);
    root.right.right = new TreeNode(2);
    return root;
  }

  // 前序遍历二叉树
  public static void preOrder(TreeNode root) {
    if (root != null) {
      // 打印根结点
      System.out.print(root.val + " ");
      // 访问左子树
      preOrder(root.left);
      // 访问右子树
      preOrder(root.right);
    }
  }
}