import java.util.Stack;

public class EveryDayTemperatures {

  public static void main(String[] args) {
    int[] results = dailyTemperatures(
      new int[] { 63, 54, 76, 56, 37, 89, 23, 74 }
    );
    for (int i = 0; i < results.length; i++) {
      System.out.print(results[i] + " ");
    }
  }

  public static int[] dailyTemperatures(int[] temperatures) {
    int length = temperatures.length;
    int[] ans = new int[length];
    Stack<Integer> stack = new Stack<Integer>();
    for (int i = 0; i < length; i++) {
      // 取出当前温度
      int temperature = temperatures[i];
      // 如果栈不为空且栈顶温度小于当前温度
      while (!stack.isEmpty() && temperature > temperatures[stack.peek()]) {
        // 弹出
        int curIndex = stack.pop();
        // 更新温度天数
        ans[curIndex] = i - curIndex;
      }
      stack.push(i);
    }
    return ans;
  }
}