import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class MColor {
    // 结果
    public static Set<String> results = new HashSet<String>();
    public static int n, k, m, a, b, count = 0;
    public static int[][] num;
    // 颜色
    public static int[] colors;
    // 访问标识
    public static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 结点数量
        n = sc.nextInt();
        // 连接数
        k = sc.nextInt();
        // 颜色的数量
        m = sc.nextInt();
        // 初始化
        num = new int[n][n];
        colors = new int[n];
        visited = new boolean[m];
        // 读取输入
        for (int i = 0; i < k; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            num[a - 1][b - 1] = num[b - 1][a - 1] = 1;
        }
        for (int i = 0; i < colors.length; i++) {
            colors[i] = -1;
        }
        // 从第一个开始涂色
        findColor(0, "");
        System.out.println("种类：" + count);
        results.forEach(System.out::println);
    }

    public static void findColor(int count, String s) {
        if (count == n) {
            results.add(s);
            MColor.count++;
            return;
        }
        // 每一种颜色
        for (int i = 0; i < m; i++) {
            boolean isValid = true;
            // 每一个节点
            for (int j = 0; j < n; j++) {
                // 查找联通的是否同一种颜色
                if (num[count][j] == 1 && i == colors[j]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                // 访问当前
                visited[i] = true;
                // 涂色
                colors[count] = i;
                // 下一个节点
                findColor(count + 1, s + i);
                // 回溯
                colors[count] = -1;
                // 重置当前节点
                visited[i] = false;
            }
        }
    }
}