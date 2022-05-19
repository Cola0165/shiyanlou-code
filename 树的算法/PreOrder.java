import java.util.Stack;

public class PreOrder {

  public static void main(String[] args) {
    PreOrder order = new PreOrder();
    order.preOrder(order.initTree());
  }

  public void preOrder(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    // 树为空直接返回
    if (root == null) return;
    // 先将根结点压入栈中
    stack.add(root);
    // 循环以下代码直到栈为空
    while (!stack.isEmpty()) {
      // 取出栈顶元素，可以理解为当前根结点
      TreeNode node = stack.pop();
      // 输出当前根结点
      System.out.print(node.val + " ");
      // 先将右子树压栈
      if (node.right != null) stack.push(node.right);
      // 再将左子树压栈
      if (node.left != null) stack.push(node.left);
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