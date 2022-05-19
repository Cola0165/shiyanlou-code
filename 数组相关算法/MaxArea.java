public class MaxArea {
    public static void main(String[] args) {
        // 54
        System.out.println("最大面积：" + maxArea(new int[]{4, 9, 5, 3, 6, 4, 7, 9, 5}));
        // 25
        System.out.println("最大面积：" + maxArea(new int[]{5,4,3,2,1,5}));
        // 2
        System.out.println("最大面积：" + maxArea(new int[]{2,2}));
    }

    public static int maxArea(int[] height) {
        if (height == null || height.length == 0 || height.length == 1) {
            return 0;
        }
        int i = 0;
        int j = height.length - 1;
        int sum = (j - i) * Math.min(height[i], height[j]);
        while (i != j) {
            int num = (j - i) * Math.min(height[i], height[j]);
            if (num > sum) {
                sum = num;
            }
            if (height[i] >= height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return sum;
    }
}