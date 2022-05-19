public class BestTree {
    static int dp(int l, int r, int parent, int nodes[], int data[][][]) {
        if (l > r) return 0;
        if (data[l][r][parent] != -1) return data[l][r][parent];
        int resuult = Integer.MAX_VALUE;

        for (int i = l; i <= r; ++i) {

            int left = dp(l, i - 1, i, nodes, data);
            int right = dp(i + 1, r, i, nodes, data);

            resuult = Math.min(resuult, left + right + nodes[i] * nodes[parent]);
        }

        data[l][r][parent] = resuult;
        return resuult;
    }

    public static void main(String[] args) {
        int nums[] = {7, 6, 5, 1, 3};
        int[] nodes = addVNode(nums);
        int data[][][] = new int[nums.length + 1][nums.length + 1][nums.length + 1];
        // 初始化
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                for (int k = 0; k < data.length; k++) {
                    data[i][j][k] = -1;
                }
            }
        }
        // 从第1个节点开始，其父节点是0
        int result = dp(1, nums.length, 0, nodes, data);
        System.out.println("最小节点开销：" + result);
    }

    public static int[] addVNode(int nums[]) {
        // 增加虚拟节点0
        int nodes[] = new int[nums.length + 1];
        for (int i = 1; i < nodes.length; i++) {
            nodes[i] = nums[i - 1];
        }
        return nodes;
    }
}