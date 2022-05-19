public class MoneyNum {
    public static int[] moneys = { 100, 50, 20, 10, 5, 2, 1 };
  
    public static void main(String[] args) {
      int[] results = exchange(64);
      for (int i = 0; i < results.length; i++) {
        // 张数大于 0 才打印
        if (results[i] != 0) {
          System.out.println("面值 " + moneys[i] + ": " + results[i] + " 张");
        }
      }
    }
  
    public static int[] exchange(int n) {
      int[] nums = new int[7];
      for (int i = 0; i < moneys.length; i++) {
        // 优先替换大面额
        while (n >= moneys[i]) {
          // 最多换的张数
          nums[i] = n / moneys[i];
          // 剩余的钱
          n = n - moneys[i] * nums[i];
        }
      }
      return nums;
    }
  }