public class FibonacciTest {

    public int Fibonacci(int n) {
      if (n <= 0) return 0;
      if (n == 1) return 1;
      // 初始化状态
      int fibonacci1 = 0;
      int fibonacci2 = 1;
      int result = 0;
      for (int i = 2; i <= n; i++) {
        result = fibonacci1 + fibonacci2;
        fibonacci1 = fibonacci2;
        fibonacci2 = result;
      }
      // 返回最后的状态
      return result;
    }
  }