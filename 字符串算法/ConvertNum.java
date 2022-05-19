public class ConvertNum {
    public static int convert(String str) {
        if (str == null) {
            return 0;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i >= str.length()
                || (str.charAt(i) != '-'
                && str.charAt(i) != '+' && !((str.charAt(i) >= '0') && (str.charAt(i) <= '9')))) {
            return 0;
        }
        int sign = 1;
        if (i < str.length() && (str.charAt(i) == '-' || i < str.length() && str.charAt(i) == '+')) {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        int sum = 0;
        for (; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                if (sign == 1) {
                    if (sum > Integer.MAX_VALUE / 10 || sum == Integer.MAX_VALUE / 10 && (str.charAt(i) - '0') > 7) {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    if (sum > (Integer.MAX_VALUE) / 10 || sum == (Integer.MAX_VALUE) / 10 && (str.charAt(i) - '0') > 8) {
                        return Integer.MIN_VALUE;
                    }
                }
                sum = sum * 10 + (str.charAt(i) - '0');
            } else {
                return sum * sign;
            }
        }
        return sum * sign;
    }

    public static void main(String[] args) {
        System.out.println(convert(" 32"));
        System.out.println(convert("+32"));
        System.out.println(convert(" -32"));
        System.out.println(convert("32 abc"));
        System.out.println(convert("8917239179619698"));
    }
}