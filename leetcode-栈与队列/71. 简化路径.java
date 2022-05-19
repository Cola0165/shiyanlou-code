import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        //以"/"切割字符串
        String[] split = path.split("/");
        for (int i = 0; i < split.length; i++) {
            switch (split[i]){
                case "..":
                    //栈判空, 如果为空则没有意义
                    if(stack.isEmpty()){
                        break;
                    }else{
                        //合法,则弹出栈顶的"."和栈顶的后一个元素,因为抵消了
                        stack.pop();
                    }
                    break;
                //遇到""不进行任何操作
                case "":
                    break;
                //遇到"."不进行任何操作
                case ".":
                    break;
                default:
                    stack.push(split[i]);
                    break;
            }
        }
        //如果栈为空则说明是根目录
        if(stack.isEmpty()){
            return "/";
        }else{
            //将栈里的元素一个一个取出来,并为其中间和最前面添加上"/"
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < stack.size(); i++) {
                str.append("/"+stack.get(i));
            }
            return str.toString();
        }
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String path=in.next();
        in.close();
        System.out.println(simplifyPath(path));
    }

}