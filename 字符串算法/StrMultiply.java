public class StrMultiply {
    public static void main(String[] args) {
        System.out.println("1234 * 1 = " + multiply("1234", "1"));
        System.out.println("1234 * 789 = " + multiply("1234", "789"));
        System.out.println("0 * 789 = " + multiply("0", "789"));
        System.out.println("12 * 34 = " + multiply("12", "34"));
    }

    private static String multiply(String num1, String num2) {
        if (num1 == "0" || num2 == "0") return "0";

        String result = "";
        for (int i = num2.length() - 1, j = 0; i >= 0; i--) {
            String mulResult = mul(num1, num2.charAt(i));
            // 后面补零
            for (int k = 0; k < j; k++) {
                mulResult += "0";
            }
            result = add(result, mulResult);
            j++;
        }
        return result;
    }

    // 乘数的每一位和被乘数相乘
    private static String mul(String str, char c) {
        // 进位
        int carry = 0;
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            int temp = (str.charAt(i) - '0') * (c - '0') + carry;
            result = (temp % 10) + result;
            carry = temp / 10;
        }
        if (carry != 0) result = (carry) + result;
        return result;
    }

    // 两个字符串相加
    private static String add(String s1, String s2) {
        if (s1 == "" || s1 == "0") return s2;
        if (s2 == "" || s2 == "0") return s1;

        int len1 = s1.length() - 1;
        int len2 = s2.length() - 1;
        int carry = 0;
        String result = "";
        while (len1 >= 0 || len2 >= 0) {
            int x = (len1 >= 0) ? s1.charAt(len1) : '0';
            int y = (len2 >= 0) ? s2.charAt(len2) : '0';
            int s = (x - '0') + (y - '0') + carry;
            result = (s % 10) + result;
            carry = s / 10;
            if (len1 >= 0) len1--;
            if (len2 >= 0) len2--;
        }
        if (carry != 0) result = "1" + result;
        return result;
    }
}