import java.util.Stack;

public class InOrder {

  public static void main(String[] args) {
    InOrder order = new InOrder();
    order.inOrder(order.initTree());
  }

  public void inOrder(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        // 将当前结点压栈
        stack.push(root);
        // 遍历其左子树
        root = root.left;
      }
      // 出栈
      root = stack.pop();
      // 当前结点被遍历
      System.out.print(root.val + " ");
      // 右结点
      root = root.right;
    }
  }

  // 构造初始化树
  public TreeNode initTree() {
    // 构造二叉树
    TreeNode treeNode = new TreeNode(1);
    treeNode.left = new TreeNode(2);
    treeNode.right = new TreeNode(3);
    treeNode.left.left = new TreeNode(4);
    treeNode.left.right = new TreeNode(5);
    treeNode.right.left = new TreeNode(6);
    return treeNode;
  }
}