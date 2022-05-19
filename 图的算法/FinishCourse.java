
import java.util.ArrayList;
import java.util.List;

public class FinishCourse {
    // 邻接矩阵
    List<List<Integer>> group = new ArrayList<List<Integer>>();
    //0，没访问过；1，正在访问；2，完成访问
    int[] visited;

    // 表示使否存在有向环
    boolean hasRing = false;

    public boolean canFinish(int n, int[][] infos) {

        // 初始化临接矩阵
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<Integer>();
            group.add(list);
        }

        // 访问标识
        visited = new int[n];

        // 将节点相连，构成有向图
        for (int[] nums : infos) {
            group.get(nums[1]).add(nums[0]);
        }

        // 遍历每一个节点
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                dfs(i);
                // 存在环，返回
                if (hasRing) {
                    return false;
                }
            }
        }
        return true;
    }

    public void dfs(int i) {
        // 访问
        visited[i] = 1;
        for (int j : group.get(i)) {
            // 正在访问，说明存在环，相互依赖
            if (visited[j] == 1) {
                hasRing = true;
                return;
            } else {
                //继续向下递归搜索
                if (visited[j] == 0) {
                    dfs(j);
                }
            }
        }
        // 该节点搜索完成
        visited[i] = 2;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] infos = {{0, 1}, {5, 3}, {3, 2}, {1, 2}, {4, 3}};
        FinishCourse finishCourse = new FinishCourse();
        System.out.println("是否能完成课程：" + finishCourse.canFinish(n, infos));
    }
}