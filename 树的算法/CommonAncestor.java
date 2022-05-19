public class CommonAncestor {

    public static void main(String[] args) {
      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
  
      // 初始化需要查找的结点
      TreeNode p = new TreeNode(4);
      TreeNode q = new TreeNode(5);
  
      root.left.left = p;
      root.left.right = q;
      root.right.left = new TreeNode(6);
  
      TreeNode commonNode = lowestCommonAncestor(root, p, q);
      // 输出共同节点
      System.out.println("common node: " + commonNode.val);
    }
  
    public static TreeNode lowestCommonAncestor(
      TreeNode root,
      TreeNode p,
      TreeNode q
    ) {
      // 如果任何一个等于null，直接返回
      if (root == null || p == root || q == root) {
        return root;
      }
      // 在左子树中查找
      TreeNode left = lowestCommonAncestor(root.left, p, q);
      // 在右子树中查找
      TreeNode right = lowestCommonAncestor(root.right, p, q);
  
      // 如果两边都查找到
      if (left != null && right != null) {
        // 返回其最近共同祖先
        return root;
      }
  
      return left == null ? right : left;
    }
  }