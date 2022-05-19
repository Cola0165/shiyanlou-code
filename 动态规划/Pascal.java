import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascal {
    public static List<List<Integer>> generatePascal(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(new Integer[]{1}));
        List<Integer> dp = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            List<Integer> everyRow = new ArrayList<>();
            // 每一行前面一个数字1
            everyRow.add(1);
            for (int j = 1; j < i - 1; j++) {
                everyRow.add(j, dp.get(j - 1) + dp.get(j));
            }
            // 每一行后面一个数字1
            everyRow.add(1);
            ans.add(everyRow);
            dp = everyRow;
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> pascalData = generatePascal(6);
        for (List<Integer> row : pascalData) {
            for (int data : row) {
                System.out.print(data + " ");
            }
            System.out.println();
        }
    }
}