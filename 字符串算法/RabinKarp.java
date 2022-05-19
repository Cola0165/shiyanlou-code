public class RabinKarp {

    public static void main(String[] args) {
      String source = "ABABDABCD";
      String pattern = "ABC";
      System.out.println(isMatch(pattern, source));
    }
  
    static boolean isMatch(String pattern, String source) {
      // 计算模式串的 hash 值
      long hash = hash(pattern);
      int pLen = pattern.length();
      for (int i = 0; i + pLen <= source.length(); i++) {
        // 计算子串的 hash 值
        long tempHash = hash(source.substring(i, i + pLen));
        if (hash == tempHash) {
          return true;
        }
      }
      return false;
    }
  
    private static long hash(String str) {
      long hash = 0;
      for (int i = 0; i != str.length(); i++) {
        hash = 31 * hash + str.charAt(i);
      }
      // 防止溢出
      return hash % Long.MAX_VALUE;
    }
  }