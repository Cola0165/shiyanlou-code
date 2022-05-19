public class MinSubArrayLen {
    public static void main(String[] args) {
        System.out.println("符合条件的最小子数组长度："
                + minSubArrayLen(9, new int[]{3, 5, 2, 6, 4, 1, 2, 7}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = 0;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                // 和大于target，移动左边界
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left++;
            }
            // 移动右边界
            right++;
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}