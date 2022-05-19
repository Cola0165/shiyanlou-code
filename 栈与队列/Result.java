import java.util.Stack;

public class Result {

  public static void main(String[] args) {
    System.out.println(evalRPN(new String[] { "4", "14", "7", "/", "+" }));
  }

  public static int evalRPN(String[] strs) {
    Stack<Integer> stack = new Stack<Integer>();
    int n = strs.length;
    for (int i = 0; i < n; i++) {
      // 操作符
      String operation = strs[i];
      // 如果是操作数
      if (isNumber(operation)) {
        stack.push(Integer.parseInt(operation));
      } else {
        // 取出操作数
        int num2 = stack.pop();
        int num1 = stack.pop();
        // 根据操作符计算
        switch (operation) {
          case "+":
            stack.push(num1 + num2);
            break;
          case "-":
            stack.push(num1 - num2);
            break;
          case "*":
            stack.push(num1 * num2);
            break;
          case "/":
            stack.push(num1 / num2);
            break;
          default:
        }
      }
    }
    // 弹出栈顶数据
    return stack.pop();
  }

  public static boolean isNumber(String operation) {
    return !(
      "+".equals(operation) ||
      "-".equals(operation) ||
      "*".equals(operation) ||
      "/".equals(operation)
    );
  }
}