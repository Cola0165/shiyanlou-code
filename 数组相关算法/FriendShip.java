public class FriendShip {

    public static void main(String[] args) {
      int[][] relationShips = {
        { 1, 2 },
        { 1, 3 },
        { 2, 5 },
        { 3, 5 },
        { 4, 6 },
      };
      int result = getNums(6, relationShips);
      System.out.println("朋友圈的个数：" + result);
    }
  
    public static int getNums(int n, int relationShips[][]) {
      int count = 0;
      int[] results = new int[n + 1];
      for (int i = 0; i <= n; i++) {
        results[i] = -1;
      }
      // 合并朋友圈
      for (int i = 0; i < relationShips.length; i++) {
        unionFriends(relationShips[i][0], relationShips[i][1], results);
      }
  
      // 计算朋友圈个数（由于不使用第一个节点，因此我们统计时也排除第一个节点）
      for (int i = 1; i < n + 1; i++) {
        if (results[i] < 0) count++;
      }
      return count;
    }
  
    public static void unionFriends(int p1, int p2, int[] results) {
      // 获取自己的朋友圈的根源
      int root1 = getRoot(p1, results);
      // 获取自己的朋友圈的根源
      int root2 = getRoot(p2, results);
      // 不相等则合并
      if (root1 != root2) {
        // 圈子的领导者的值不断累加，越来越小
        results[root1] = results[root1] + results[root2];
        // 其他节点存储的值是领导者的索引
        results[root2] = root1;
      }
    }
  
    public static int getRoot(int p, int[] results) {
      // 最终的根应该小于 0
      while (results[p] >= 0) {
        p = results[p];
      }
      return p;
    }
  }