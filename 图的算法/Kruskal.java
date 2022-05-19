
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Kruskal {

    private final List<Edge> edges;
    private final int countOfNode;
    private int parents[];
    private int deep[];
    private int sum = 0;

    //构造函数
    public Kruskal() {
        // 边
        edges = new ArrayList<>();
        // 节点数
        countOfNode = 4;
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 2, 2));
        edges.add(new Edge(0, 3, 9));
        edges.add(new Edge(1, 2, 2));
        edges.add(new Edge(1, 3, 4));
        edges.add(new Edge(2, 3, 1));
    }

    public void mini() {
        parents = new int[countOfNode];
        deep = new int[countOfNode];

        // 初始化数组
        for (int i = 0; i < countOfNode; i++) {
            parents[i] = i;
            deep[i] = 1;
        }
        // 从小到大排序
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.value - o2.value;
            }
        });
        // 每一条边
        for (int i = 0; i < edges.size(); i++) {
            union(edges.get(i).start, edges.get(i).end, edges.get(i).value);
        }
        System.out.println("最小的总权值" + sum);
    }

    // 查询根结点
    int findRoot(int i) {
        if (parents[i] == i) {
            return i;
        } else {
            parents[i] = findRoot(parents[i]);
            return parents[i];
        }
    }

    // 将 j 合并到 i中去
    public void union(int i, int j, int value) {
        //先找到两个根节点
        int x = findRoot(i);
        int y = findRoot(j);
        if (x != y) {
            Arrays.stream(parents).forEach(p -> System.out.print(p + " "));
            System.out.println();
            System.out.println(i
                    + " -> " + j + "  权值为" + value);
            sum += value;
        }
        if (deep[x] <= deep[y]) {
            parents[x] = y;

        } else {
            parents[y] = x;
        }
        //如果深度相同且根节点不同，则新的根节点的深度+1
        if (deep[x] == deep[y] && x != y)
            deep[y]++;
    }

    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal();
        kruskal.mini();
    }

    class Edge {
        public int start;
        public int end;
        public int value;

        public Edge(int start, int end, int value) {
            this.start = start;
            this.end = end;
            this.value = value;
        }
    }
}