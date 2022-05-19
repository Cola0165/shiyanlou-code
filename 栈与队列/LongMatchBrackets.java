import java.util.Stack;

public class LongMatchBrackets {
    public static void main(String[] args) {
        String s = "()(()))()()(";
        System.out.println("\"" + s + "\"" + " 的最长有效括号长度为：" + findLongMatch(s));
    }

    public static int findLongMatch(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    int curMaxLen = i - stack.peek();
                    maxLength = Math.max(maxLength, curMaxLen);
                } else {
                    stack.push(i);
                }
            }
        }
        return maxLength;
    }
}