public class Josephus {

    public static void main(String[] args) {
        int result = josephus(5, 3);
        System.out.println();
        System.out.println("最后一个出圈的："+result);
    }
  
    public static int josephus(int n, int m) {
      int[] peoples = new int[n];
      // 当前指针索引
      int index = -1;
      // 循环数 0 到 m
      int count = 0;
      // 环中剩下的人数
      int remainNum = n;
      // 将所有的人数都淘汰出圈
      while (remainNum > 0) {
        // 索引 +1
        index++;
        // 如果当前索引已经超过数组的长度，则需要将索引移动至数组的开头位置
        if (index == n) {
          // 索引移动至开头
          index = 0;
        }
        // 如果元素的值等于 -1，说明这个士兵已经被淘汰了，不计数，直接跳过
        if (peoples[index] == -1) {
          continue;
        } else {
          // 否则计数
          count++;
          // 如果计数到 m，说明该士兵需要被淘汰
          if (count == m) {
            System.out.print(index + " ");
            // 数值置为 -1
            peoples[index] = -1;
            // 计数归 0
            count = 0;
            // 圈内的人数减少 1
            remainNum--;
          }
        }
      }
      return index;
    }
  }