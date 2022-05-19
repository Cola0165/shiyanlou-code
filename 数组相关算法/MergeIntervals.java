import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 4}, {3, 7}, {1, 2}, {5, 8}, {11, 18}, {9, 10}};
        System.out.println(merge(intervals));
    }

    public static List<List<Integer>> merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        List<List<Integer>> results = new ArrayList<>();
        for (int i = 0; i < intervals.length; ++i) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            if (results.size() == 0
                    || results.get(results.size() - 1).get(1) < left) {
                List<Integer> temp = new ArrayList<>();
                temp.add(left);
                temp.add(right);
                results.add(temp);
            } else {
                results.get(results.size() - 1)
                        .set(1, Math.max(results.get(results.size() - 1).get(1), right));
            }
        }
        return results;
    }
}