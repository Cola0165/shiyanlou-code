public class MinRoute {
    public static void main(String[] args) {
        int map[][] = {{12, 7, 22, 6},
                {3, 18, 9, 41},
                {11, 3, 5, 24},
                {12, 6, 14, 7}};
        int dp[][] = minPathSum(map);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println("");
        }
        System.out.println("最小路径和：" + dp[dp.length - 1][dp[0].length - 1]);
    }

    public static int[][] minPathSum(int[][] map) {
        int dp[][] = new int[map.length][map[0].length];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = map[i][j];
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + map[i][j];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + map[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + map[i][j];
                }
            }
        }
        return dp;
    }
}