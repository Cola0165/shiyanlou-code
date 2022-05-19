
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfThree {
    public static void main(String[] args) {
        int[] nums = {-3, -6, 3, 4, 8, -2, -2, -3, -1};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return results;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                if (low > i + 1 && nums[low] == nums[low - 1]) {
                    low++;
                    continue;
                }
                if (high < nums.length - 1 && nums[high] == nums[high + 1]) {
                    high--;
                    continue;
                }
                if (nums[i] + nums[low] + nums[high] == 0) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[low]);
                    result.add(nums[high]);
                    results.add(result);
                    low++;
                    high--;
                    continue;
                } else {
                    if (nums[i] + nums[low] + nums[high] > 0) {
                        high--;
                        continue;
                    } else {
                        low++;
                        continue;
                    }
                }
            }
        }
        return results;
    }
}