
import java.util.ArrayList;

public class GenerateParenthesis {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>(10);
        backtrack("", 0, 0, n, result);
        return result;
    }

    private void backtrack(String string, int leftNum, int rightNum, int n, ArrayList<String> result) {
        // 长度等于两倍的括号对数
        if (string.length() == n * 2) {
            result.add(string);
            return;
        }
        // 左括号数量少于右括号，则可以添加左括号
        if (leftNum < n) {
            backtrack(string + "(", leftNum + 1, rightNum, n, result);
        }
        // 右括号数量少于左括号，则可以继续添加右括号
        if (rightNum < leftNum) {
            backtrack(string + ")", leftNum, rightNum + 1, n, result);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        ArrayList<String> res = generateParenthesis.generateParenthesis(3);
        res.forEach(s -> System.out.println(s + " "));
    }
}