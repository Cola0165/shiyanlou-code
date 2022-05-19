public class IslandNum {
    private static int parents[];
    private static int deep[];

    public static void main(String[] args) {
        char[][] map = {{'0', '0', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '1', '0'}};
        System.out.println("岛屿数量：" + numIslands(map));
    }

    public static int numIslands(char[][] map) {
        int m = map.length;
        int n = map[0].length;
        parents = new int[m * n];
        deep = new int[m * n];
        int spaces = 0;

        // 初始化
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                parents[index] = index;
                deep[index] = 1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                if (map[i][j] == '1') {
                    if (i - 1 >= 0 && map[i - 1][j] == '1') {
                        union(index, (i - 1) * n + j);
                    }
                    if (j - 1 >= 0 && map[i][j - 1] == '1') {
                        union(index, i * n + j - 1);
                    }
                } else {
                    spaces++;
                }
            }
        }
        int result = 0;
        System.out.println("parents 数组如下：");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(parents[i * n + j] + " ");
                if (parents[i * n + j] == (i * n + j)) {
                    result++;
                }
            }
            System.out.println("");
        }
        System.out.println("");
        return result - spaces;
    }

    static void union(int i, int j) {
        //先找到两个根节点
        int x = findRoot(i);
        int y = findRoot(j);
        if (deep[x] <= deep[y])
            parents[x] = y;
        else
            parents[y] = x;
        //如果深度相同且根节点不同，则新的根节点的深度+1
        if (deep[x] == deep[y] && x != y)
            deep[y]++;
    }

    // 查询根结点
    static int findRoot(int i) {
        if (parents[i] == i) {
            return i;
        } else {
            parents[i] = findRoot(parents[i]);
            return parents[i];
        }
    }
}