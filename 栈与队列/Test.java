import java.util.Stack;

class Myqueue {
  Stack<Integer> stack1 = new Stack<Integer>();
  Stack<Integer> stack2 = new Stack<Integer>();

  // 加入数据全部压入 stack1
  public void push(int node) {
    stack1.push(node);
  }

  // 弹出数据
  public int pop() {
    if (!stack2.isEmpty()) {
      // stack2 不为空，则直接取出 stack2 的数据
      return stack2.pop();
    } else {
      // 将 stack1 的数据全部倒入 stack2
      while (!stack1.isEmpty()) {
        stack2.push(stack1.pop());
      }
    }
    return stack2.pop();
  }
}

public class Test {

  public static void main(String[] args) {
    Myqueue myqueue = new Myqueue();
    myqueue.push(1);
    myqueue.push(2);
    System.out.println(myqueue.pop());
    myqueue.push(3);
    myqueue.push(4);
    System.out.println(myqueue.pop());
  }
}