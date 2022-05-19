
public class FindMedian {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int right1 = nums1.length - 1;
        int right2 = nums2.length - 1;
        // 求两次取平均（如果总数为偶数，则取得中间两个取平均，如果总数为奇数，则两次取出中位数取平均，还是中位数）
        return (getMidNum(nums1, 0, right1, nums2, 0, right2, (nums1.length + nums2.length + 1) / 2)
                + getMidNum(nums1, 0, right1, nums2, 0, right2, (nums1.length + nums2.length + 2) / 2)) * 0.5;
    }

    public static double getMidNum(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k) {
        // 数组1需要比较的长度
        int len1 = right1 - left1 + 1;
        // 数组2需要比较的长度
        int len2 = right2 - left2 + 1;
        if (len1 > len2) {
            // 保证更长的数组在后面
            return getMidNum(nums2, left2, right2, nums1, left1, right1, k);
        }
        // 如果数组1需要比较的段的长度为0，那么说明中位数存在在数组2中
        if (len1 == 0) {
            // 索引位置自然是数组2需要比较的左边界+个数-1
            return nums2[left2 + k - 1];
        }
        // 如果k为1了，那么肯定是两个数组的第一个数之中的一个，更小的就是中位数
        if (k == 1) {
            return Math.min(nums1[left1], nums2[left2]);
        }
        // 取出第一个数组的中间位置的数
        int num1_K = Math.min(left1 + k / 2 - 1, right1);
        // 取出第二个数组的中间位置的数
        int num2_k = Math.min(left2 + k / 2 - 1, right2);
        // 两个数相比，如果第一个数比第二个数小，说明中位数在数组1的后半段和数组2中
        if (nums1[num1_K] < nums2[num2_k]) {
            k = k - (num1_K - left1 + 1);
            return getMidNum(nums1, num1_K + 1, right1, nums2, left2, right2, k);
        } else {
            // 如果第一个数比第二个数大，说明中位数在数组2的前半段和数组1中
            k = k - (num2_k - left2 + 1);
            return getMidNum(nums1, left1, right1, nums2, num2_k + 1, right2, k);
        }
    }

    public static void main(String[] args) {
        int nums1[] = {1, 4, 7, 12, 13, 25, 35};
        int nums2[] = {2, 4, 6, 7, 8, 13, 45, 65};
        System.out.println("中位数：" + findMedianSortedArrays(nums1, nums2));
    }
}