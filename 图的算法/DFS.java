public class DFS {
    public int count = 0;
    int m;
    int n;
    boolean[][] visited;
    char[][] maps;
  
    public DFS(char[][] maps) {
      m = maps.length;
      n = maps[0].length;
      visited = new boolean[m][n];
      this.maps = maps;
    }
  
    public static void main(String[] args) {
      char[][] maps = {
        { '*', '*', '*', '#', '#' },
        { '*', '#', '#', '*', '#' },
        { '*', '#', '*', '*', '#' },
        { '#', '#', '#', '*', '#' },
        { '#', '#', '*', '*', '#' },
      };
      DFS dfs = new DFS(maps);
      dfs.dfs();
      System.out.println("联通块数量： " + dfs.count);
    }
  
    public void dfs() {
      for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
          // 没被访问过，并且是 #
          if (!visited[i][j] && maps[i][j] == '#') {
            // 计数 +1
            count++;
            dfs(i, j);
          }
        }
      }
    }
  
    public void dfs(int i, int j) {
      // 非法边界
      if (i < 0 || i >= m || j < 0 || j >= n) {
        return;
      }
      // 被访问或者不是 #
      if (visited[i][j] || maps[i][j] != '#') {
        return;
      }
      visited[i][j] = true;
      // 右
      dfs(i, j + 1);
      // 左
      dfs(i, j - 1);
      // 下
      dfs(i + 1, j);
      // 上
      dfs(i - 1, j);
    }
  }