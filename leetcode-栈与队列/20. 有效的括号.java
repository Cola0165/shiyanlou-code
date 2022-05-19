import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
public class Main {
    public static  Map<Character,Character> mapChar = new HashMap<Character, Character>(){{
        //注意map中 key 为  右括号
        put('}', '{'); put(']', '['); put(')', '(');
    }};

    public static void main(String[] args) {
        // String str = "(){{([])}}[]";
        Scanner in=new Scanner(System.in);
        String str=in.next();
        in.close();
        boolean b = isValid(str);
        // System.out.println("输入的字符串为："+str);
        System.out.println(b?"YES":"NO");
    }
    private static boolean isValid(String str){
        int length = str.length();
        //长度为奇数直接返回false
        if (length%2 != 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++){
            Character c = str.charAt(i);

            if (!stack.empty() && stack.peek().equals(mapChar.get(c))){
                //移除
                stack.pop();
            }else {
                //添加
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}