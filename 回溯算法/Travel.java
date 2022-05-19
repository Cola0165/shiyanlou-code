import java.util.Arrays;
public class Travel {
    //城市数量
    public int count;
    // 最小路程
    int minDistance = Integer.MAX_VALUE;
    // 最短路径
    int[] minRoutes;
    // 当前路程
    int currDistance;
    // 当前路径
    int[] currRoutes;
    // 是否访问过
    int[] visited;
    //城市之间的距离
    int[][] distances;

    public Travel(int count){
        // 城市数量
        this.count = count;
        // 最小路径
        minRoutes = new int[count];
        // 当前路径
        currRoutes = new int[count];
        // 是否被访问
        visited = new int[count];
        // 城市之间的距离
        distances = new int[count][count];
        // 当前路程
        currDistance = 0;
    }

    public void travel(int step){
        // 是否遍历完所有的城市
        if(step >= count){
            if(currDistance < minDistance){
                // 拷贝保存当前的路径
                minRoutes = Arrays.copyOf(currRoutes,4);
                minDistance = currDistance;
                System.out.println("当前最短路程是" + minDistance + ",路径是 " + Arrays.toString(minRoutes));
            }
            return;
        }
        // 继续走下一个城市
        for(int i = 0; i < count; i++){
            // 下一步没有走过，并且可达，则选中，currRoutes[step-1]是当前城市的索引
            if(visited[i] == 0 && distances[currRoutes[step-1]][i] != -1){
                currRoutes[step] = i;
                currDistance += distances[currRoutes[step-1]][i];
                visited[i] = 1;

                // 走下一个城市
                travel(step+1);

                //退回到上一步
                currRoutes[step] = -1;
                // 访问标识重置
                visited[i] = 0;
                // 当前路程中减去
                currDistance -= distances[currRoutes[step-1]][i];
            }
        }
    }

    public static void main(String[] args) {
        Travel travel = new Travel(4);

        travel.distances[0][0] = -1;
        travel.distances[0][1] = 30;
        travel.distances[0][2] = 6;
        travel.distances[0][3] = 4;

        travel.distances[1][0] = 30;
        travel.distances[1][1] = -1;
        travel.distances[1][2] = 5;
        travel.distances[1][3] = 10;

        travel.distances[2][0] = 6;
        travel.distances[2][1] = 5;
        travel.distances[2][2] = -1;
        travel.distances[2][3] = 20;

        travel.distances[3][0] = 4;
        travel.distances[3][1] = 10;
        travel.distances[3][2] = 20;
        travel.distances[3][3] = -1;

        // 初始化
        for(int i = 0; i < travel.count; i++){
            travel.currRoutes[i] = -1;
            travel.visited[i] = 0;
        }

        // 从城市 0 出发
        travel.currRoutes[0] = 0;
        // 访问标识
        travel.visited[0] = 1;
        // 向城市1出发
        travel.travel(1);

        System.out.println("最短距离： " + travel.minDistance);
        System.out.println("最短路线： " + Arrays.toString(travel.minRoutes));
    }
}