public class FourQueen {
    public int count = 0;
    public static void main(String[] args) {
        FourQueen fourQueen = new FourQueen();
        fourQueen.findSolution();
        System.out.println("共有：" + fourQueen.count + "种不同的放置方法！");
    }

    public void findSolution() {
        // 四皇后
        int[][] maps = new int[4][4];
        // 从第 0 行开始
        queen(maps, 0);
    }

    // 查找
    public void queen(int[][] maps, int row) {
        // 如果第四个满足，那么就说明摆放满足
        if (row == maps.length) {
            count++;
            // 打印
            printQueen(maps);
            System.out.println();
            return;
        }
        for (int col = 0; col < maps.length; col++) {
            // 验证当前位置是否可以放皇后
            if (isVaild(maps, row, col)) {
                // 摆放
                maps[row][col] = 1;
                // 下一行递归
                queen(maps, row + 1);
                // 撤销当前摆放，回溯上一步
                maps[row][col] = 0;
            }
        }
    }

    // 打印当前摆放
    private void printQueen(int[][] maps) {
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps.length; j++) {
                System.out.print(maps[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }

    // 判断当前摆放是否符合同一列同一对角线
    private boolean isVaild(int[][] maps, int row, int col) {

        // 当前列是否有重复
        for (int i = row - 1; i >= 0; i--) {
            if (maps[i][col] == 1) {
                return false;
            }
        }
        // 右上角对角线
        for (int i = row - 1, j = col + 1; i >= 0 && j < maps[0].length; i--, j++) {
            if (maps[i][j] == 1) {
                return false;
            }
        }

        // 检查左上角对角线
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (maps[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}