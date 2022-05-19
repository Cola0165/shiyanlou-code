
import java.util.*;

public class Prim {
  static final int INF = Integer.MAX_VALUE;

  public static int[] prim(int[][] maps) {
    // 已经加入最小生成树的集合
    List<Integer> visited = new ArrayList<Integer>();
    // 初始化 0 节点
    visited.add(0);
    // 父节点
    int[] parents = new int[maps.length];
    // 首节点没有父节点
    parents[0] = -1;
    int value;
    int start = 0;
    int end = 0;
    // 循环知道所有的节点都加入
    while (visited.size() < maps.length) {
      value = INF;
      // 从已经加入的节点
      for (Integer index : visited) {
        // 查找任意的节点
        for (int i = 0; i < maps.length; i++) {
          // 如果还没有被访问过
          if (!visited.contains(i)) {
            // 保存路径最短的
            if (maps[index][i] < value) {
              // 更新保存的值
              start = index;
              end = i;
              value = maps[index][i];
            }
          }
        }
      }
      System.out.println(Arrays.toString(parents));
      // 加入最短路径的点
      visited.add(end);
      // 保存其父节点
      parents[end] = start;
    }
    return parents;
  }

  public static void main(String[] args) {
    int[][] matrix = new int[][] {
      { 0, 2, 2, 9 },
      { 2, 0, 2, 4 },
      { 2, 2, 0, 1 },
      { 9, 4, 1, 0 },
    };
    int[] parents = prim(matrix);
    System.out.println(Arrays.toString(parents));
  }
}