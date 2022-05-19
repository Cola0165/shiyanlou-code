import java.util.LinkedList;
import java.util.Queue;

class MyListStack {
    Queue<Integer> queue;


    public MyListStack() {
        queue = new LinkedList<Integer>();
    }


    public void push(int x) {
        // 记录加入之前的元素个数
        int n = queue.size();
        queue.offer(x);
        // 将前n个元素出队列之后，放到队列尾部
        for (int i = 0; i < n; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

}

class MyListStackTest {
    public static void main(String[] args) {
        MyListStack myListStack = new MyListStack();
        myListStack.push(1);
        System.out.println("栈顶元素：" + myListStack.top());
        myListStack.push(2);
        System.out.println("栈顶元素：" + myListStack.top());
        myListStack.push(3);
        System.out.println("栈顶元素：" + myListStack.top());
        System.out.println("出栈元素：" + myListStack.pop());
        System.out.println("出栈元素：" + myListStack.pop());
        System.out.println("出栈元素：" + myListStack.pop());
        System.out.println("栈是否为空：" + myListStack.empty());
    }
}