import java.util.Scanner;

public class Main {
    public static int longestValidParentheses(String s) {
        int left = 0;
        int right = 0;
        int longestLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
    
            if (left == right) {
                longestLen = longestLen > 2 * left ? longestLen : 2 * left; 
            } else if (right > left) {
                left = 0;
                right = 0; 
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
    
            if (left == right) {
                longestLen = longestLen > 2 * left ? longestLen : 2 * left; 
            } else if (left > right) {
                left = 0;
                right = 0; 
            }
        }
        return longestLen;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.next();
        in.close();
        System.out.println(longestValidParentheses(str));
    }
}

// public static int longestValidParentheses(String s) {
//     int[] dp = new int[s.length()];

// int longestLen = 0;
// for (int i = 1; i < s.length(); i++) {
//     if (s.charAt(i) == ')') {
//         if (s.charAt(i-1) == '(') {
//             dp[i] = i-2 >= 0 ? (dp[i-2] + 2) : 2; // process when i = 1
//             longestLen = dp[i] > longestLen ? dp[i] : longestLen; 
//         } else if (s.charAt(i-1) == ')' && i-1-dp[i-1] >= 0 && s.charAt(i-1-dp[i-1]) == '(') {
//             if (i-1-dp[i-1]-1 >= 0) {
//                 dp[i] = dp[i-1] + 2 + dp[i-1-dp[i-1]-1];
//             } else {
//                 dp[i] = dp[i-1] + 2;
//             }
//             longestLen = dp[i] > longestLen ? dp[i] : longestLen;
//         }
//     }
// }
// return longestLen;
// }

// import java.util.LinkedList;

// public static int longestValidParentheses(String s) {
//     LinkedList<Integer> stack = new LinkedList<>();
// stack.add(-1);
// int longestLen = 0;
// for (int i = 0; i < s.length(); i++) {
//     if (s.charAt(i) == '(') {
//         stack.addFirst(i);
//     } else {
//         stack.poll();
//         if (stack.size() == 0) {
//             stack.addFirst(i);
//         } else {
//             longestLen = longestLen > i - stack.getFirst() ? longestLen : i - stack.getFirst();
//         }
//     }
// }

// return longestLen;
// }