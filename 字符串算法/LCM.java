
public class LCM {

    // 欧几里得算法求最大公约数
    public static int gcd(int m, int n) {
        while (n > 0) {
            int temp = m % n;
            m = n;
            n = temp;
        }
        return m;
    }

    // 求最小公倍数
    public static int lcm(int m, int n) {
        int gcd = gcd(m, n);
        int result = m * n / gcd;
        return result;
    }

    static String findLcm(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        int g = gcd(n, m);
        if (mul(str1, m / g).equals(mul(str2, n / g)))
            return mul(str1, m / g);
        else
            return "-1";
    }

    // 拼接字符串
    static String mul(String str1, int k) {
        String res = "";
        while (k > 0) {
            res += str1;
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        LCM lcm = new LCM();
        // aaaaaa
        System.out.println("aa 和 aaa 的最小公倍串是：" + lcm.findLcm("aa", "aaa"));
        // aaa
        System.out.println("a 和 aaa 的最小公倍串是：" + lcm.findLcm("a", "aaa"));
        // -1
        System.out.println("ab 和 abc 的最小公倍串是：" + lcm.findLcm("ab", "abc"));
        // abababababab
        System.out.println("ababab 和 abab 的最小公倍串是：" + lcm.findLcm("ababab", "abab"));
    }
}