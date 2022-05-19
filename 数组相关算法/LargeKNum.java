import java.util.ArrayList;
import java.util.PriorityQueue;

public class LargeKNum {

  public static void main(String[] args) {
    topK(new int[] { 4, 5, 1, 6, 2, 7, 3, 8 }, 4)
      .forEach(e -> System.out.print(e + " "));
  }

  public static ArrayList<Integer> topK(int[] input, int k) {
    if (input == null || k > input.length || k <= 0) {
      return new ArrayList<>();
    }
    // 优先队列，最小堆
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
      (o1, o2) -> o1 - o2
    );
    for (int num : input) {
      priorityQueue.add(num);
      // 超出，则抛弃较小的元素
      if (priorityQueue.size() > k) {
        priorityQueue.poll();
      }
    }
    return new ArrayList<>(priorityQueue);
  }
}