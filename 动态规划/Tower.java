public class Tower {

    public static void main(String[] args) {
      int[][] datas = {
        { 1 },
        { 3, 5 },
        { 7, 5, 2 },
        { 9, 3, 4, 11 },
        { 11, 1, 2, 5, 7 },
      };
      System.out.println("最大路径为：" + maxRoute(datas));
    }
  
    public static int maxRoute(int data[][]) {
      int max = 0;
      int dp[][] = new int[data.length][data.length];
      dp[0][0] = data[0][0];
      for (int i = 1; i < data.length; i++) {
        for (int j = 0; j <= i; j++) {
          if (j == 0) {
            // 左边界，直接是右上角的数字相加
            dp[i][j] = dp[i - 1][j] + data[i][j];
          } else {
            // 不是左边界，取左上角也右上角的最大值
            dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + data[i][j];
          }
          max = Math.max(dp[i][j], max);
        }
      }
      print(dp);
      return max;
    }
  
    // 打印矩阵
    public static void print(int[][] results) {
      for (int i = 0; i < results.length; i++) {
        for (int j = 0; j < results[0].length; j++) {
          System.out.print(results[i][j] + " ");
        }
        System.out.println("");
      }
    }
  }