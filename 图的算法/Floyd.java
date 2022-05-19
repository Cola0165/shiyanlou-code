public class Floyd {
    // 图
    int[][] maps;
    // 表示无法到达
    private static final int INF = Integer.MAX_VALUE;
  
    public Floyd(int[][] maps) {
      this.maps = maps;
    }
  
    public void floyd() {
      int[][] distance = new int[maps.length][maps[0].length];
      // 初始化
      for (int i = 0; i < maps.length; i++) {
        for (int j = 0; j < maps.length; j++) {
          distance[i][j] = maps[i][j];
        }
      }
      // 模拟加入一个节点
      for (int i = 0; i < maps.length; i++) {
        // 影响两两之间的最短路径
        for (int j = 0; j < maps.length; j++) {
          for (int k = 0; k < maps.length; k++) {
            // 只要有一段不可达，就是不可达，否则计算途径新加入的节点的路径
            int temp = (distance[j][i] == INF || distance[i][k] == INF)
              ? INF
              : distance[j][i] + distance[i][k];
            // 判断最短路径是否要修改
            if (distance[j][k] > temp) {
              distance[j][k] = temp;
              print(distance);
            }
          }
        }
      }
    }
  
    public static void main(String[] args) {
      int maps[][] = {
        { 0, 11, 4, INF },
        { 1, 0, 23, 6 },
        { 56, 5, 0, 7 },
        { INF, 34, 11, 0 },
      };
      Floyd floyd = new Floyd(maps);
      floyd.floyd();
    }
  
    public static void print(int[][] distance) {
      // 打印
      for (int i = 0; i < distance.length; i++) {
        for (int j = 0; j < distance.length; j++) System.out.printf(
          "%2d  ",
          distance[i][j]
        );
        System.out.println("");
      }
      System.out.println("===================");
    }
  }