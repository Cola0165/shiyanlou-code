public class MaxBalancedStr {
    public static int maxBalancedStrSplit(String s) {
        int maxValue = 0, num = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if (ch == 'A') {
                ++num;
            } else {
                --num;
            }
            if (num == 0) {
                ++maxValue;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        String s = "AABBABABAAABBB";
        System.out.println(s + " 的最多平衡字符串数量：" + maxBalancedStrSplit(s));
    }
}