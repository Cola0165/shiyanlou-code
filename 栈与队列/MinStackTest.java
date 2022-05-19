
import java.util.Stack;

class MinStack {
  // 数据
  private Stack<Integer> datas = new Stack<>();
  // 最小值
  private Stack<Integer> mins = new Stack<>();

  public void push(int node) {
    // 添加到数据堆栈
    datas.push(node);
    // 最小值堆栈
    if (mins.isEmpty()) {
      mins.push(node);
    } else {
      // 小于栈顶元素才放入
      int min = mins.peek();
      if (node <= min) {
        mins.push(node);
      }
    }
  }

  public int pop() {
    if (datas.isEmpty()) {
      return -1;
    } else {
      // 取出数据堆栈的栈顶元素
      int value = datas.peek();
      // 与最小堆栈栈顶元素相对则一样弹出
      if (value == mins.peek()) {
        mins.pop();
      }
      return datas.pop();
    }
  }

  public int peek() {
    if (datas.isEmpty()) {
      return -1;
    }
    // 数据堆栈的栈顶
    return datas.peek();
  }

  public int min() {
    if (mins.isEmpty()) {
      return -1;
    }
    // 最小值堆栈的栈顶元素
    return mins.peek();
  }
}

public class MinStackTest {

  public static void main(String[] args) {
    MinStack minStack = new MinStack();
    minStack.push(1);
    minStack.push(4);
    // 1
    System.out.println(minStack.min());
    minStack.push(3);
    minStack.push(5);
    // 1
    System.out.println(minStack.min());
    // 5
    System.out.println(minStack.pop());
    // 1
    System.out.println(minStack.min());
    minStack.push(0);
    // 0
    System.out.println(minStack.peek());
  }
}