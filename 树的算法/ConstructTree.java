/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class ConstructTree {

    public static void main(String[] args) {
      int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
      int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
      TreeNode root = constructBinaryTree(pre, in);
      preOrder(root);
    }
  
    public static TreeNode constructBinaryTree(int[] pre, int[] in) {
      if (pre == null || pre.length == 0 || in == null || in.length == 0) {
        return null;
      }
      return constructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }
  
    static TreeNode constructBinaryTree(
      int[] pre,
      int startPre,
      int endPre,
      int[] in,
      int startIn,
      int endIn
    ) {
      // 不符合条件直接返回null
      if (startPre > endPre || startIn > endIn) {
        return null;
      }
      // 构建根结点
      TreeNode root = new TreeNode(pre[startPre]);
      for (int index = startIn; index <= endIn; index++) {
        if (in[index] == pre[startPre]) {
          // 构建左子树
          root.left =
            constructBinaryTree(
              pre,
              startPre + 1,
              startPre + (index - startIn),
              in,
              startIn,
              index - 1
            );
          // 构建右子树
          root.right =
            constructBinaryTree(
              pre,
              (index - startIn) + startPre + 1,
              endPre,
              in,
              index + 1,
              endIn
            );
          break;
        }
      }
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