import java.util.LinkedList;
import java.util.Queue;

public class TreeDepth {

  public static void main(String[] args) {
    TreeNode root = initTree();
    System.out.println("树的高度为：" + treeDepth(root));
  }

  public static int treeDepth(TreeNode root) {
    Queue<TreeNode> tree = new LinkedList<>();
    if (root != null) {
      tree.add(root);
    }
    int length = 0;
    // 如果队列不为空
    while (!tree.isEmpty()) {
      // 队列的大小
      int size = tree.size();
      while (size > 0) {
        // 弹出第一个结点
        TreeNode node = tree.peek();
        // 左节点
        if (node.left != null) {
          tree.add(node.left);
        }
        // 右结点
        if (node.right != null) {
          tree.add(node.right);
        }
        // 删除第一个节点
        tree.remove(node);
        size--;
      }
      length++;
    }
    return length;
  }

  // 初始化树结构
  public static TreeNode initTree() {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.left.right.left = new TreeNode(7);
    return root;
  }
}