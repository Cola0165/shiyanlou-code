
import java.util.ArrayList;
import java.util.List;

public class PhoneNum {
    public List<String> phoneNumCombinations(String digits) {
        String[] str = {
                "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        String nowStr = "";
        addItem(result, digits, nowStr, str);
        return result;
    }

    private void addItem(List<String> result, String digits, String nowStr, String[] str) {
        if (digits.length() == 0) {
            result.add(nowStr);
            return;
        }
        int num = digits.charAt(0) - '2';
        for (int i = 0; i < str[num].length(); i++) {
            // 选择一种字符
            nowStr = nowStr + (str[num].charAt(i));
            // 递归下一个字符选择
            addItem(result, digits.substring(1), nowStr, str);
            // 回溯
            nowStr = nowStr.substring(0, nowStr.length() - 1);
        }
    }

    public static void main(String[] args) {
        PhoneNum phoneNum = new PhoneNum();
        List<String> results = phoneNum.phoneNumCombinations("234");
        results.forEach(r -> System.out.print(r + "  "));
    }
}