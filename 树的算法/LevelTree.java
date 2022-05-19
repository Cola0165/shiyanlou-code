import java.util.ArrayList;
import java.util.LinkedList;
class TreeNode {
    // 结点的值
    int val;
    // 左结点的引用
    TreeNode left;
    // 右结点的引用
    TreeNode right;

    // 构造方法
    TreeNode(int x) {
      val = x;
    }
  }


public class LevelTree {

  public static void main(String[] args) {
    TreeNode root = initTree();
    ArrayList<Integer> results = print(root);
    results.forEach(e -> System.out.print(e + " "));
  }

  // 按照层次打印
  public static ArrayList<Integer> print(TreeNode root) {
    // 结果集
    ArrayList<Integer> results = new ArrayList<>();
    // 双向队列
    LinkedList<TreeNode> queue = new LinkedList<>();
    if (root != null) {
      // 将根节点添加进去队列中
      queue.add(root);
      // 循环判断队列是否为空
      while (!queue.isEmpty()) {
        // 取出第一个元素
        TreeNode treeNode = queue.pollFirst();
        // 加入结果集
        results.add(treeNode.val);
        // 如果左子树不为空，则添加至队尾
        if (treeNode.left != null) {
          queue.add(treeNode.left);
        }
        // 如果右子树不为空，则添加至队尾
        if (treeNode.right != null) {
          queue.add(treeNode.right);
        }
      }
    }
    return results;
  }

  // 构造初始化树
  public static TreeNode initTree() {
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