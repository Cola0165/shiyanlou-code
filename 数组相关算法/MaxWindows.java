import java.util.LinkedList;

public class MaxWindows {

  public static void main(String[] args) {
    int[] nums = { 3, 5, -1, 3, 2, 5, 1, 6 };
    int[] results = MaxWindows.maxSlidingWindow(nums, 3);
    for (int result : results) {
      System.out.print(result + " ");
    }
  }

  // 滑动窗口
  public static int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length <= 0 || k <= 0) {
      return new int[0];
    }
    int len = nums.length;
    int[] results = new int[len - k + 1];
    // 双向队列
    LinkedList<Integer> queue = new LinkedList<>();
    for (int i = 0; i < len; i++) {
      // 移除比较小的元素
      while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
        queue.removeLast();
      }
      // 添加当前元素
      queue.addLast(i);
      // 移除索引不在有效窗口内的元素
      if (i - queue.peekFirst() >= k) {
        queue.removeFirst();
      }
      // 计算窗口内的数据
      if (i >= k - 1) {
        results[i - k + 1] = nums[queue.peekFirst()];
      }
    }
    return results;
  }
}