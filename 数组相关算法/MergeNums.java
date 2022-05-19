public class MergeNums {
    public static void main(String[] args) {
        int nums1[] = {1, 3, 7, 9, 11, -1, -1, -1, -1, -1, -1};
        int nums2[] = {2, 4, 8, 10, 15, 34};
        merge(nums1, 5, nums2, 6);
        for (int r : nums1) {
            System.out.print(r + " ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[index] = nums1[i];
                i--;
                index--;
            } else {
                nums1[index] = nums2[j];
                j--;
                index--;
            }
        }

        while (j >= 0) {
            nums1[index] = nums2[j];
            j--;
            index--;
        }
    }
}