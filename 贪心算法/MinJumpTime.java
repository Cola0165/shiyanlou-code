public class MinJumpTime {
    public static int jump(int[] nums) {
        int jumpTimes = 0;
        int left = 0;
        int right = 0;
        // 如果右边界已经覆盖最后一个索引，就结束，说明已经可以跳到最后一个位置
        while (right < nums.length - 1) {
            int maxPosition = 0;
            // 在当前区间能跳到的最远的位置
            for (int i = left; i <= right; i++) {
                maxPosition = Math.max(nums[i] + i, maxPosition);
            }
            // 左边界就是之前的右边界+1
            left = right + 1;
            // 更新右边界为最远的位置
            right = maxPosition;
            // 跳的次数加1
            jumpTimes++;
        }
        return jumpTimes;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4, 1, 3, 3, 2, 4, 2, 3, 4, 1};
        System.out.println("最少的跳跃次数：" + jump(nums));
    }
}