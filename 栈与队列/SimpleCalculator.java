import java.util.Stack;

public class SimpleCalculator {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        // 1 表示正，-1表示负
        int sign = 1, result = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                // 数字直接统计
                int currentNum = ch - '0';
                while (i + 1 < length && Character.isDigit(s.charAt(i + 1)))
                    currentNum = currentNum * 10 + s.charAt(++i) - '0';
                result = result + sign * currentNum;
            } else if (ch == '+') {
                sign = 1;
            } else if (ch == '-') {
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                // 重新初始化
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result = stack.pop() * result + stack.pop();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "10-(21-9)+4";
        System.out.println(s + " = " + calculate(s));

        String s1 = "2+(125-23)-80";
        System.out.println(s1 + " = " + calculate(s1));
    }
}