import java.util.*;
public class MaximumProduct {

    public static boolean containSet(Set<Character> mySet, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (mySet.contains(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static int maximumProduct(String[] strs) {
        Arrays.sort(strs, (o1, o2) -> Integer.compare(o2.length(), o1.length()));
        int maxProduct = 0;
        for (int i = 0; i < strs.length; i++) {
            Set<Character> mySet = new HashSet<>();
            strs[i].chars().forEach((c) -> mySet.add((char) c));
            for (int j = i; j < strs.length; j++) {
                if (!containSet(mySet, strs[j])) {
                    maxProduct = Math.max(strs[i].length() * strs[j].length(), maxProduct);
                }
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println("最大的乘积：" + maximumProduct(new String[]{"a", "ab", "abc", "cd", "bcd", "abcd"}));
    }
}