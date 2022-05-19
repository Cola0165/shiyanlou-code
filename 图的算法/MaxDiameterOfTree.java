import java.util.ArrayList;
import java.util.List;

class TreeEdge {
    int start;
    int end;

    public TreeEdge(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MaxDiameterOfTree {
    List<List<int[]>> linkMap;
    // 最远的节点索引
    long farIndex = 0;
    // 最大直径
    long max = 0;

    public int solve(int n, TreeEdge[] treeEdges, int[] edgeValue) {
        // 初始化临接表
        linkMap = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            linkMap.add(new ArrayList<>());
        }
        // 将边的值转换成为邻接表
        for (int i = 0; i < treeEdges.length; i++) {
            // 1-2 表示 节点1可以到节点2，节点2 也可以到节点1
            linkMap.get(treeEdges[i].start).add(new int[]{treeEdges[i].end, edgeValue[i]});
            linkMap.get(treeEdges[i].end).add(new int[]{treeEdges[i].start, edgeValue[i]});
        }

        // 随便找个根节点开始搜索距离它最远的节点
        dfs(0, -1, 0);
        max = 0;
        System.out.println("查找到最远的端点：" + farIndex);
        //找到最远点后，其实就是其中一个端点
        dfs(farIndex, -1, 0);
        return (int) max;
    }

    // 深度优先搜索
    private void dfs(long curIndex, long preIndex, long distance) {
        // 更新最大值
        if (distance > max) {
            max = distance;
            farIndex = curIndex;
        }
        // 遍历当前节点连接的所有节点
        for (int[] child : linkMap.get((int) curIndex)) {
            // 不等于前面节点的时候，才递归，要不会死循环
            if (child[0] != (int) preIndex) {
                // 递归到下一个关联的节点
                dfs(child[0], curIndex, distance + child[1]);
            }
        }
    }

    public static void main(String[] args) {
        TreeEdge[] treeEdges = {
                new TreeEdge(0, 1),
                new TreeEdge(1, 5),
                new TreeEdge(1, 2),
                new TreeEdge(2, 3),
                new TreeEdge(2, 4)};
        int edgeValues[] = {3, 4, 2, 1, 5};
        MaxDiameterOfTree maxDiameterOfTree = new MaxDiameterOfTree();
        int maxValue = maxDiameterOfTree.solve(6, treeEdges, edgeValues);
        System.out.println("最大直径：" + maxValue);
    }
}