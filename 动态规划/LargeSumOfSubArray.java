public class LargeSumOfSubArray {

    public static void main(String[] args) {
      System.out.println("sum: " + simpleSolution(new int[] { 1, -3, 4, 2, -8 }));
    }
  
    public static int simpleSolution(int[] array) {
      if (array == null || array.length == 0) {
        return 0;
      }
      int result = Integer.MIN_VALUE;
      // 从每一个字符开始
      for (int i = 0; i < array.length; i++) {
        int tempSum = 0;
        // 每一种长度的子串（合法的索引范围）
        for (int j = i; j < array.length; j++) {
          tempSum = tempSum + array[j];
          // 当前最大值和保存的最大值相比较
          if (tempSum > result) {
            result = tempSum;
          }
        }
      }
      return result;
    }
  }