import java.util.Stack;

public class BracketsMatch {

  public static void main(String[] args) {
    System.out.println(isValid("[()]{}{[()()]()}"));
  }

  public static boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      // 左括号，压入堆栈
      if (c == '(' || c == '[' || c == '{') stack.push(c); else {
        // 右括号，堆栈为空，不匹配
        if (stack.isEmpty()) {
          return false;
        }
        // 弹出栈顶元素
        char top = stack.pop();
        // 判断是否匹配左右括号
        if (c == ')' && top != '(') return false;
        if (c == ']' && top != '[') return false;
        if (c == '}' && top != '{') return false;
      }
    }
    return stack.isEmpty();
  }
}