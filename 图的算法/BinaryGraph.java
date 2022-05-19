public class BinaryGraph {

    private static int INIT = 0;
    private static int RED = 1;
    private static int BLUE = 2;

    public boolean judgeBinaryGraph(int[][] graph) {
        int len = graph.length;
        int[] colors = new int[len];
        boolean isBinaryGraph = true;
        // 遍历所有节点，因为不一定是全联通的图
        for (int i = 0; i < graph.length; i++) {
            // 如果没有染色，就执行以下步骤
            if (colors[i] == INIT) {
                // 第 0 个节点默认染红色
                isBinaryGraph = dfs(graph, i, RED, colors, isBinaryGraph);
            }
        }
        return isBinaryGraph;
    }

    /**
     * 深度优先搜索
     */
    public boolean dfs(int[][] graph, int index, int color, int[] colors, boolean isBinaryGraph) {
        // 当前节点染色
        colors[index] = color;
        System.out.println("索引为" + index + "的节点，染上" + (color == 1 ? "红色" : "蓝色"));
        // 下一个颜色
        int nextColor = color == RED ? BLUE : RED;
        // 遍历邻接矩阵中能直接相连的点
        for (int i = 0; i < graph[index].length; i++) {
            // 获取直接相连的节点的索引
            int nextIndex = graph[index][i];
            // 没有染色
            if (colors[nextIndex] == INIT) {
                // 继续递归，深度优先
                isBinaryGraph = dfs(graph, nextIndex, nextColor, colors, isBinaryGraph);
                if (!isBinaryGraph) {
                    // 如果返回结果不满足，则继续返回，不再执行其他元素的操作
                    return isBinaryGraph;
                }
            } else if (colors[nextIndex] != nextColor) {
                // 颜色冲突，直接返回
                isBinaryGraph = false;
                return isBinaryGraph;
            }
        }
        return isBinaryGraph;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {3},
                {3, 4},
                {4, 5},
                {0, 1},
                {1, 2, 7, 8},
                {2, 8, 6},
                {5, 9},
                {4, 9},
                {4, 5, 9},
                {7, 8, 6}
        };
        BinaryGraph binaryGraph = new BinaryGraph();
        boolean result = binaryGraph.judgeBinaryGraph(graph);
        System.out.println("是否二分图：" + result);
    }
}