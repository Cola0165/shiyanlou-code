import java.util.LinkedList;
import java.util.Queue;

class Node {
  int x, y;

  Node(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

public class BFS {
  static int width, height;
  static char[][] maps;
  static boolean[][] visited;
  // 左 上 右 下
  static int[][] directors = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
  static int[][] results;
  static Queue<Node> queue = new LinkedList<Node>();

  static int bfs(int x, int y) {
    // 初始化加入头结点
    queue.offer(new Node(x, y));
    visited[x][y] = true;
    results[x][y] = 0;

    // 循环判断队列是否为空
    while (!queue.isEmpty()) {
      // 弹出头结点
      Node currentNode = queue.peek();
      queue.poll();
      // 当前的 x，y 坐标
      int currentX = currentNode.x;
      int currentY = currentNode.y;
      // 遍历四个方向
      for (int i = 0; i < 4; i++) {
        // 下一个坐标
        int nextX = currentX + directors[i][0];
        int nextY = currentY + directors[i][1];
        // 判断不是 * 且合法，且没有访问过
        if (
          nextX >= 0 &&
          nextX < width &&
          nextY >= 0 &&
          nextY < height &&
          maps[nextX][nextY] != '*' &&
          !visited[nextX][nextY]
        ) {
          // 如果是出口
          if (maps[nextX][nextY] == 'T') {
            // 直接 +1 返回
            return results[currentX][currentY] + 1;
          } else {
            // 置为访问过
            visited[nextX][nextY] = true;
            // 路程 +1
            results[nextX][nextY] = results[currentX][currentY] + 1;
            // 添加到队列
            queue.offer(new Node(nextX, nextY));
          }
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    maps = new char[][]{
        { '*', 'S', '*', '#' },
        { '#', '#', '#', '*' },
        { '*', '*', '#', '*' },
        { '*', '#', '#', '*' },
        { 'T', '#', '*', '*' }};
    width = maps.length;
    height = maps[0].length;
    visited = new boolean[width][height];
    results = new int[width][height];
    System.out.println("最终步数：" + bfs(0, 1));
  }
}