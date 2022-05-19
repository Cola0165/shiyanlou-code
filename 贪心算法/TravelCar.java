public class TravelCar {

    public static void greedy(
      int distances[],
      int distanceOnce,
      int numOfGasStation
    ) {
      // 每相邻两个加油站的距离不超过 n，否则无解
      for (int i = 0; i < numOfGasStation; i++) {
        if (distances[i] > distanceOnce) {
          return;
        }
      }
      // 出发加油第一次
      int count = 1;
      System.out.println("第 0 个加油站加油一次");
      // 一次行驶，不能超过90
      int onceTimeDistance = 0;
      for (int i = 0; i < numOfGasStation; i++) {
        // 尝试行驶，看看超不超
        onceTimeDistance += distances[i];
        // 如果超过
        if (onceTimeDistance > distanceOnce) {
          // 上一个加油站加油次数加1
          count++;
          // 行驶距离变成上一个加油站到现在的
          onceTimeDistance = distances[i];
          System.out.println("第 " + i + " 个加油站加油");
        }
      }
      System.out.println("加油次数：" + count + " 次");
    }
  
    public static void main(String[] args) {
      int[] distances = { 30, 40, 80, 12, 78 };
      int count = 5;
      int n = 90;
      greedy(distances, n, count);
    }
  }