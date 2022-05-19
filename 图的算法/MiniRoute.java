
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class MiniRoute {
    public static int miniSpanningTree(int n, int m, int[][] cost) {
        // 已经添加的点
        HashSet<Integer> added = new HashSet<>();
        //存储点
        ArrayList<int[]> list = new ArrayList<>();
        // 排序
        Arrays.sort(cost, (l1, l2) -> {
            return l1[2] - l2[2];
        });

        for (int[] data : cost) {
            list.add(data);
        }
        int result = 0;
        result += cost[0][2];
        // 添加最短的边
        added.add(cost[0][0]);
        added.add(cost[0][1]);
        System.out.println(cost[0][0] + " <----> " + cost[0][1] + " 被选中，长度为：" + cost[0][2]);
        while (true) {
            // 循环里面的所有的边
            for (int i = 1; i < list.size(); i++) {
                // 有且只有一端已经在树上，才添加
                if ((added.contains(list.get(i)[0]) && !added.contains(list.get(i)[1]))
                        || (!added.contains(list.get(i)[0]) && added.contains(list.get(i)[1]))) {
                    result += list.get(i)[2];
                    added.add(list.get(i)[0]);
                    added.add(list.get(i)[1]);
                    System.out.println(+list.get(i)[0] + " <----> " + list.get(i)[1] + " 被选中，长度为：" + list.get(i)[2]);
                    // 移除当前的边
                    list.remove(list.get(i));

                    break;
                }
            }
            // 所有的节点都被添加到树上
            if (added.size() == n) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] cost = {
                {6, 5, 2},
                {6, 1, 3},
                {6, 2, 4},
                {5, 2, 7},
                {1, 2, 1},
                {2, 4, 3},
                {2, 3, 5},
                {3, 4, 1},
                {3, 7, 6}};
        System.out.println("最小成本：" + miniSpanningTree(7, 9, cost));
    }
}