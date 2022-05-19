public class LCS {

    public static void main(String[] args) {
      findLCS("abbcdd", "abdbcabd");
    }
  
    public static int findLCS(String str1, String str2) {
      int n = str1.length();
      int m = str2.length();
      // 状态定义
      int[][] dp = new int[n + 1][m + 1];
      // 初始化状态
      for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= m; j++) {
          dp[i][j] = 0;
        }
      }
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
          // 如果两个字符相等
          if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
          } else {
            // 不相等的时候，取 dp[i - 1][j] 和 dp[i][j - 1] 的最大
            dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
          }
        }
      }
      print(dp);
      return dp[n][m];
    }
  
    // 打印矩阵
    public static void print(int[][] results) {
      for (int i = 0; i < results.length; i++) {
        for (int j = 0; j < results[0].length; j++) {
          System.out.print(results[i][j] + " ");
        }
        System.out.println("");
      }
      System.out.println(
        "最长公共子串的长度为： " +
        results[results.length - 1][results[0].length - 1]
      );
    }
  }