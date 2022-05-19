import java.util.Arrays;
import java.util.Scanner;

// 边
class Edge {
  // 起点
  public int start;
  // 终点
  public int end;
  // 权值
  public int value;

  Edge(int start, int end, int value) {
    this.start = start;
    this.end = end;
    this.value = value;
  }
}

public class BellmanFord {
  // 顶点 0 到其他点的距离
  public long[] results;

  // 返回第 0 个顶点到其它顶点的最短距离
  public boolean getPaths(int n, Edge[] edges) {
    results = new long[n];
    // 初始化
    for (int i = 1; i < n; i++) {
      results[i] = Integer.MAX_VALUE;
    }
    // 每个顶点
    for (int i = 1; i < n; i++) {
      // 每条边
      for (int j = 0; j < edges.length; j++) {
        // 0->end 是否大于 (0->start + start->end)
        if (results[edges[j].end] > results[edges[j].start] + edges[j].value) {
          results[edges[j].end] = results[edges[j].start] + edges[j].value;
          Arrays.stream(results).forEach(r -> System.out.print(r + " "));
          System.out.println("");
        }
      }
    }
    boolean valid = true;
    for (int i = 1; i < n; i++) {
      // 判断负边
      if (results[edges[i].end] > results[edges[i].start] + edges[i].value) {
        valid = false;
        break;
      }
    }
    return valid;
  }

  public static void main(String[] args) {
    BellmanFord bellmanFord = new BellmanFord();
    Scanner in = new Scanner(System.in);
    // 输入一个图的顶点总数
    int n = in.nextInt();
    // 输入一个图的边总数
    int numOfEdges = in.nextInt();
    Edge[] edges = new Edge[numOfEdges];
    // 输入具体边数据
    for (int i = 0; i < numOfEdges; i++) {
      int start = in.nextInt();
      int end = in.nextInt();
      int value = in.nextInt();
      edges[i] = new Edge(start, end, value);
    }
    if (bellmanFord.getPaths(n, edges)) {
      for (int i = 0; i < bellmanFord.results.length; i++) System.out.print(
        bellmanFord.results[i] + " "
      );
    } else System.out.println("存在负边，没有最短距离");
  }
}