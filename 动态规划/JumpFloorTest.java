public class JumpFloorTest {

    public static void main(String[] args) {
      System.out.println("F(4) = " + jumpFloor(4));
    }
  
    public static int jumpFloor(int target) {
      if (target <= 0) return 0;
      // 初始化
      int total = 1;
      for (int i = 1; i < target; i++) {
        // 状态转移
        total = 2 * total;
      }
      return total;
    }
  }