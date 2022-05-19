public class Palindrome {

    public static void main(String[] args) {
      System.out.println(longestPalindrome("abddbc"));
    }
  
    public static String longestPalindrome(String str) {
      int size = str.length();
      if (size <= 1) return str;
      boolean[][] results = new boolean[size][size];
      // 起始索引位置
      int startIndex = 0;
      // 保存回文串最大长度
      int max = 0;
      // 初始化状态，长度为 1 和 2 的子串
      for (int i = 0; i < size; i++) {
        results[i][i] = true;
        if (i < size - 1 && str.charAt(i) == str.charAt(i + 1)) {
          results[i][i + 1] = true;
          startIndex = i;
          max = 2;
        }
      }
      // 回文串的长度从 3 开始计算
      for (int length = 3; length <= size; length++) {
        for (int i = 0; i <= size - length; i++) {
          int j = i + length - 1;
          // 去掉当前字符的前面长度为 length 的子串是回文串，且当前字符与对折字符相等
          if (results[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
            results[i][j] = true;
            startIndex = i;
            max = length;
          }
        }
      }
      print(results);
      if (startIndex == 0 && max == 0) return String.valueOf(str.charAt(0));
      // 返回回文串
      return str.substring(startIndex, startIndex + max);
    }
  
    // 打印矩阵
    public static void print(boolean[][] results) {
      for (int i = 0; i < results.length; i++) {
        for (int j = 0; j < results[0].length; j++) {
          System.out.print(results[i][j] ? "T " : "F ");
        }
        System.out.println("");
      }
      System.out.println("========================== ");
    }
  }