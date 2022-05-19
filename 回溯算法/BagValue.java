import java.util.ArrayList;
import java.util.List;

public class BagValue {
    // 当前重量
    private int currentWeight;
    // 最大价值
    private int maxValue;
    // 当前价值
    private int currentValue;

    public static void main(String[] args) {
        List<Bag> bags = new ArrayList<>();
        bags.add(new Bag(10, 32));
        bags.add(new Bag(8, 4));
        bags.add(new Bag(5, 12));
        bags.add(new Bag(3, 32));
        System.out.println(new BagValue().getMaxValue(bags, 13));
    }

    // 获取最大的价值
    public int getMaxValue(List<Bag> bags, double maxWeight) {
        // 判断非法情况
        if (bags == null || bags.size() == 0 || maxWeight == 0) {
            return 0;
        }
        // 打印包裹
        bags.forEach(b -> System.out.println(b.weight + " " + b.value));
        // 保存包裹访问状态
        boolean[] visited = new boolean[bags.size()];
        // 选择包裹，从第一件开始
        select(0, bags, maxWeight, visited);
        return maxValue;
    }

    public void select(int i, List<Bag> bags, double totalWeight, boolean[] visited) {
        for (; i < bags.size(); i++) {
            if (!visited[i]) {
                // 总的重量小于限制的最大大小
                if (currentWeight + bags.get(i).weight <= totalWeight) {
                    // 判断当前价值
                    if (currentValue + bags.get(i).value > maxValue) {
                        // 更新价值
                        maxValue = currentValue + bags.get(i).value;
                    }
                } else {
                    continue;
                }
                // 放进入背包中
                currentWeight = currentWeight + bags.get(i).weight;
                currentValue = currentValue + bags.get(i).value;
                // 标识被访问过
                visited[i] = true;
                // 选择下一个包裹
                select(i + 1, bags, totalWeight, visited);
                // 相当于取出当前的包裹，回溯到上一步
                visited[i] = false;
                // 将物品从背包中取出的状态
                currentWeight = currentWeight - bags.get(i).weight;
                currentValue = currentValue - bags.get(i).value;
            }
        }

    }
}

class Bag {
    public int weight;
    public int value;

    Bag(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}