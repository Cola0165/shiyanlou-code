import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;

public class FindPathForTree {

  public static void main(String[] args) {
    TreeNode root = initTree1();
    ArrayList<ArrayList<Integer>> results = findPath(root, 18);
    results
      .stream()
      .forEach(
        r -> {
          r.forEach(e -> System.out.print(e + " --> "));
          System.out.println("");
        }
      );
  }

  public static ArrayList<ArrayList<Integer>> findPath(
    TreeNode root,
    int target
  ) {
    // 结果集
    ArrayList<ArrayList<Integer>> results = new ArrayList<>();
    // 队列
    LinkedList<Integer> queue = new LinkedList<>();
    int sum = 0;
    if (root != null) {
      // 从根节点开始
      addDatas(root, target, results, queue, sum);
    }
    return results;
  }

  public static void addDatas(
    TreeNode root,
    int target,
    ArrayList<ArrayList<Integer>> results,
    LinkedList<Integer> queue,
    Integer sum
  ) {
    if (root != null) {
      // 累加当前的值
      sum = sum + root.val;
      // 添加到队列中
      queue.add(root.val);
      // 如果和满足，并且是叶子节点
      if (sum == target && root.left == null && root.right == null) {
        addResult(results, queue);
      } else {
        // 递归左子树
        addDatas(root.left, target, results, queue, sum);
        // 递归右子树
        addDatas(root.right, target, results, queue, sum);
      }
      // 处理完，弹出最后一个值，相当于回溯
      queue.pollLast();
      // 和的值也需要回溯
      sum = sum - root.val;
    }
  }

  public static void addResult(
    ArrayList<ArrayList<Integer>> results,
    Queue<Integer> queue
  ) {
    // 将结果添加到最后的结果集
    ArrayList<Integer> result = (ArrayList<Integer>) queue
      .stream()
      .collect(Collectors.toList());
    results.add(result);
  }

  // 构造树
  public static TreeNode initTree1() {
    TreeNode root = new TreeNode(8);
    root.left = new TreeNode(6);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(5);
    root.left.right = new TreeNode(7);
    root.right.left = new TreeNode(9);
    root.right.right = new TreeNode(2);
    return root;
  }
}