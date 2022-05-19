import java.util.LinkedList;
import java.util.Scanner;

public class Maze {
    public int[][] maze;
    public LinkedList<Position> queue;
    public boolean[][] visited;
    // 行
    public int row;
    public int col;

    public Maze(int row, int col) {
        this.row = row;
        this.col = col;
        maze = new int[row][col];
        // 双向链表，可以当成堆栈使用
        queue = new LinkedList<>();
        visited = new boolean[row][col];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入迷宫的行数：");
        int row = scanner.nextInt();
        System.out.println("请输入迷宫的列数：");
        int col = scanner.nextInt();
        Maze maze = new Maze(5, 5);
        System.out.println("请输入" + row + "行" + col + "列的迷宫：");
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                maze.maze[i][j] = scanner.nextInt();
                maze.visited[i][j] = false;
            }
        }
        maze.findPath();
    }
    public void findPath() {
        int i = 0;
        int j = 0;
        // 进去第一个格子
        visited[i][j] = true;
        queue.push(new Position(i, j));
        // 堆栈不为空，而且横纵坐标都在合法的范围
        while (!queue.isEmpty() && (!(i == (row - 1) && (j == col - 1)))) {
            // 向右边走
            if (j < col - 1 && (maze[i][j + 1] == 0) && (!visited[i][j + 1])) {
                visited[i][j + 1] = true;
                queue.push(new Position(i, j + 1));
                j++;
            } else if (i < row - 1 && (maze[i + 1][j] == 0) && (!visited[i + 1][j])) {
                // 向下走
                visited[i + 1][j] = true;
                queue.push(new Position(i + 1, j));
                i++;
            } else if (j > 0 && (maze[i][j - 1] == 0) && (!visited[i][j - 1])) {
                // 向左边走
                visited[i][j - 1] = true;
                queue.push(new Position(i, j - 1));
                j--;
            } else if (i > 0 && (maze[i - 1][j] == 0) && (!visited[i - 1][j])) {
                // 向上走
                visited[i - 1][j] = true;
                queue.push(new Position(i - 1, j));
                i--;
            } else {
                queue.pop();
                if (queue.isEmpty()) {
                    break;
                }
                i = queue.peek().row;
                j = queue.peek().col;
            }
        }

        if (queue.isEmpty()) {
            System.out.println("没有路径");
        } else {
            System.out.println("路径如下：");
            while (!queue.isEmpty()) {
                Position p1 = queue.pollFirst();
                maze[p1.row][p1.col] = -1;
            }
            for (int k = 0; k < row; ++k) {
                for (int t = 0; t < col; ++t) {
                    System.out.print((maze[k][t] == -1 ? "#" : maze[k][t]) + " ");
                }
                System.out.println();
            }
        }
    }
}

class Position {
    public int row;
    public int col;

    public Position(int row, int col) {
        this.col = col;
        this.row = row;
    }
}