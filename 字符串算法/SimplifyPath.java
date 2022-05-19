import java.util.Stack;

public class SimplifyPath {
    static String simplifyPath(String path) {
        String temp, result = "";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) != '/') {
                for (temp = ""; i < path.length() && path.charAt(i) != '/'; i++) {
                    temp += path.charAt(i);
                }
                if ("..".equals(temp) && stack.size() > 0) {
                    stack.pop();
                } else if (!".".equals(temp) && !"..".equals(temp)) {
                    stack.push(temp);
                }
            }
        }
        for (String file : stack) {
            result += "/" + file;
        }
        return stack.size() == 0 ? "/" : result;
    }

    public static void main(String[] args) {
        System.out.println(SimplifyPath.simplifyPath("/a/./b/../../c/"));
        System.out.println(SimplifyPath.simplifyPath("/a/b/../"));
        System.out.println(SimplifyPath.simplifyPath("/a/c/./b"));
        System.out.println(SimplifyPath.simplifyPath("/a//c/./b"));
        System.out.println(SimplifyPath.simplifyPath("/user/name/"));
    }
}