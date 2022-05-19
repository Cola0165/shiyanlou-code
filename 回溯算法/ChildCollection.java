import java.util.ArrayList;
import java.util.List;

public class ChildCollection {
    List<List<Integer>> res;
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> findChildCollection(int[] nums) {
        res = new ArrayList<>();
        backTracing(nums, 0);
        return res;
    }

    public void backTracing(int[] nums, int start) {
        res.add(new ArrayList<>(list));
        if (start == nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            // 加入当前的数
            list.add(nums[i]);
            // 下一步选择
            backTracing(nums, i + 1);
            // 回溯，不选择
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        ChildCollection childCollection = new ChildCollection();
        List<List<Integer>> results = childCollection.findChildCollection(nums);
        System.out.println(results.toString());
    }
}