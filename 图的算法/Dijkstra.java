
import java.util.Arrays;

public class Dijkstra {
  // 节点数
  public int num;
  // 边
  public int[][] edges;

  public Dijkstra(int num, int[][] edges) {
    this.num = num;
    this.edges = edges;
  }

  public static void main(String[] args) {
    int[][] edges = new int[][] {
      { 0, 0, 10, 0, 30, 100 },
      { 0, 0, 5, 0, 0, 0 },
      { 10, 5, 0, 50, 0, 0 },
      { 0, 0, 50, 0, 20, 10 },
      { 30, 0, 0, 20, 0, 60 },
      { 100, 0, 0, 10, 60, 0 },
    };
    Dijkstra dijkstra = new Dijkstra(6, edges);
    // 查找到达第 0 个节点的最短距离
    int[] result = dijkstra.dijkstra(0);
    System.out.println("1 --> 6 最短路径：" + result[5]);
  }

  public int[] dijkstra(int v) {
    if (v < 0 || v >= num) {
      return null;
    }
    // 最短路径是否已经找到的标识
    boolean[] visited = new boolean[num];
    // 最短距离的集合
    int[] distance = new int[num];

    // 初始化边，如果为 0，则置为最大值
    for (int i = 0; i < num; i++) {
      for (int j = i + 1; j < num; j++) {
        // 无向图，i 到 j 和 j 到 i 一样
        if (edges[i][j] == 0) {
          edges[i][j] = Integer.MAX_VALUE;
          edges[j][i] = Integer.MAX_VALUE;
        }
      }
    }

    // copy 各个节点直接到达节点 v 的距离
    System.arraycopy(edges[v], 0, distance, 0, num);
    visited[v] = true;
    // 从源点到其余顶点的最短路径
    for (int i = 0; i < num; ++i) {
      int min = Integer.MAX_VALUE;
      int index = -1;
      // 找出到开始顶点的最短的距离
      for (int j = 0; j < num; ++j) {
        // 该顶点还没有被查找过
        if (!visited[j]) {
          // 找出路径最短的那个顶点
          if (distance[j] < min) {
            index = j;
            min = distance[j];
          }
        }
      }
      // 索引不是 -1 说明找到
      if (index != -1) {
        visited[index] = true;
      }
      System.out.print("找到index: " + index + " ， distance： ");
      // 更新当前最短路径及距离
      for (int x = 0; x < num; x++) {
        // 该节点还没被访问过
        if (!visited[x]) {
          /*
           * 当前顶点到 index 的距离（min）+index 到 x 的距离 < 现在的顶点到 x 的距离
           * 说明可以从顶点到 index，再到 x
           */
          if (
            edges[index][x] != Integer.MAX_VALUE &&
            (min + edges[index][x] < distance[x])
          ) {
            // 更新距离
            distance[x] = min + edges[index][x];
          }
        }
      }
      // 打印
      Arrays.stream(distance).forEach(d -> System.out.print(d + " "));
      System.out.println("");
    }
    return distance;
  }
}