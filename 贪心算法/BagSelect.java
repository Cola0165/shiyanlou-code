import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BagSelect {

  public static void main(String[] args) {
    List<Bag> bags = new ArrayList<>();
    bags.add(new Bag(10, 2));
    bags.add(new Bag(8, 4));
    bags.add(new Bag(5, 12));
    bags.add(new Bag(3, 32));
    bags.add(new Bag(4, 33));
    bags.add(new Bag(7, 54));
    bags.add(new Bag(3, 6));
    System.out.println(new BagSelect().getMaxValue(bags, 15));
  }

  public double getMaxValue(List<Bag> bags, double maxWeight) {
    if (bags == null || bags.size() == 0 || maxWeight == 0) {
      return 0;
    }
    // 按照单位价值排序
    bags.sort(
      new Comparator<Bag>() {

        @Override
        public int compare(Bag o1, Bag o2) {
          double result = o2.value / o2.weight - o1.value / o1.weight;
          if (result > 0) {
            return 1;
          } else {
            return -1;
          }
        }
      }
    );
    // 打印排序结果
    bags.forEach(b -> System.out.println(b.weight + " " + b.value));
    double maxValue = 0;
    for (int i = 0; i < bags.size(); i++) {
      // 可以全部放进去
      if (bags.get(i).weight <= maxWeight) {
        maxValue = maxValue + bags.get(i).value;
        maxWeight = maxWeight - bags.get(i).weight;
      } else {
        // 按照比例放进去
        maxValue =
          maxValue + bags.get(i).value / bags.get(i).weight * maxWeight;
        maxWeight = 0;
        break;
      }
    }
    return maxValue;
  }
}

class Bag {
  public double weight;
  public double value;

  Bag(double weight, double value) {
    this.weight = weight;
    this.value = value;
  }
}