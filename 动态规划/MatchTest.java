
public class MatchTest {

    public static void main(String[] args) {
      System.out.println(match("aaa", "a*a"));
    }
  
    public static boolean match(String str, String pattern) {
      if (pattern.length() == 0) {
        return str.length() == 0;
      }
      int n = str.length() + 1;
      int m = pattern.length() + 1;
      boolean[][] dp = new boolean[n][m];
      dp[0][0] = true;
      // 初始化
      for (int j = 2; j < m; j = j + 2) {
        if (dp[0][j - 2] && pattern.charAt(j - 1) == '*') {
          dp[0][j] = true;
        }
      }
      for (int i = 1; i < n; i++) {
        for (int j = 1; j < m; j++) {
          // 为 *
          if (pattern.charAt(j - 1) == '*') {
            // 前面字符匹配一次或者
            dp[i][j] =
              dp[i][j - 2] ||
              dp[i - 1][j] &&
              (
                str.charAt(i - 1) == pattern.charAt(j - 2) ||
                pattern.charAt(j - 2) == '.'
              );
          } else {
            // 当前字符相等或者前面字符相等，当前字符是 .，匹配任何字符
            dp[i][j] =
              dp[i - 1][j - 1] &&
              (
                str.charAt(i - 1) == pattern.charAt(j - 1) ||
                pattern.charAt(j - 1) == '.'
              );
          }
        }
      }
      return dp[n - 1][m - 1];
    }
  }