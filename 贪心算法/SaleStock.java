public class SaleStock {
    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int value : prices) {
            // 维护最小值
            min = Math.min(min, value);
            // 当前值减去前面最小值，与利润最大值对比，维护好利润最大值
            result = Math.max(result, value - min);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {8, 9, 2, 5, 4, 7, 1};
        System.out.println("买卖股票最大利润为：" + maxProfit(nums));
    }
}