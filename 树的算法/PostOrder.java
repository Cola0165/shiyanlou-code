import java.util.*;

public class PostOrder {

  public static void main(String[] args) {
    PostOrder order = new PostOrder();
    order.postOrder(order.initTree());
  }

  public void postOrder(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) return;
    Stack<TreeNode> stack = new Stack<>();
    // 先加入根节点
    stack.add(root);
    // 循环判断栈是否为空
    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      res.add(0, node.val);
      // 先压入左边，再压入右边，出栈的时候，就会先右边再左边
      if (node.left != null) {
        stack.add(node.left);
      }
      if (node.right != null) {
        stack.add(node.right);
      }
    }
    for (Integer item : res) {
      System.out.print(item + " ");
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