public class ShipLoad {
    public int[] num;
    public boolean[] visited;
    public int weight;
    public int result = 0;

    public static void main(String[] args) {
        ShipLoad shipLoad = new ShipLoad();
        shipLoad.num = new int[]{18, 7, 25, 36};
        shipLoad.visited = new boolean[shipLoad.num.length];
        shipLoad.weight = 80;
        shipLoad.find(0, 0);
        System.out.println(shipLoad.result);
    }

    // sum 是当前重量，i 是货物的索引
    public void find(int sum, int i) {
        for (; i < num.length; i++) {
            // 如果没有访问过
            if (!visited[i]) {
                // 尝试加上当前货物，如果能装下
                if (sum + num[i] <= weight) {
                    // 与保存的最大装载量对比更新
                    if (sum + num[i] > result) {
                        result = sum + num[i];
                    }
                } else {
                    // 超过了就放回
                    return;
                }
                // 当前货物被装过了
                visited[i] = true;
                // 递归后面的货物
                find(sum + num[i], i+1);
                // 去掉当前货物，递归其他的货物
                visited[i] = false;
            }
        }
    }
}