public class SerializeTree {
    static int index = -1;

    static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }

    static TreeNode deserialize(String str) {
        index++;
        String[] strs = str.split(",");
        TreeNode node = null;
        if (!strs[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(strs[index]));
            node.left = deserialize(str);
            node.right = deserialize((str));
        }
        return node;
    }

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

    // 构造初始化树
    static public TreeNode initTree() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);

        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.left.right = new TreeNode(7);

        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);
        return treeNode;
    }


    public static void main(String[] args) {
        TreeNode root = initTree();
        System.out.print("前序遍历：");
        preOrder(root);
        System.out.println("");
        String serializeStr = serialize(root);
        System.out.println("序列化：" + serializeStr);
        TreeNode result = deserialize(serializeStr);
        System.out.print("反序列化：");
        preOrder(result);
    }
}