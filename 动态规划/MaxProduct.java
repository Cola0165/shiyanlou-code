public class MaxProduct {
    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{1, -2, 3, -1, -4, 7, 2}));
    }

    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = nums[0];
        int preMaxProduct = nums[0];
        int preMinProduct = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 以第 n 个元素为结尾的最大乘积
            int currentMax = Math.max(Math.max(preMaxProduct * nums[i], preMinProduct * nums[i]), nums[i]);
            // 以第 n 个元素为结尾的最小乘积
            int currentMin = Math.min(Math.min(preMaxProduct * nums[i], preMinProduct * nums[i]), nums[i]);
            // 0 到 n 的连续子数组的最大乘积
            result = Math.max(result, currentMax);
            preMaxProduct = currentMax;
            preMinProduct = currentMin;
        }
        return result;
    }
}