public class FindNum {

    public static void main(String[] args) {
        int[][] array = {{1, 4, 6, 28}, {2, 7, 32, 34}, {10, 11, 67, 79}};
        System.out.println(find(32, array));
    }

    public static boolean binarySearch(int[][] array, int x1, int x2, int y1, int y2, int target) {
        if (x1 == x2 || y1 == y2) {
            return false;
        }
        int xMid = (x1 + x2) / 2, yMid = (y1 + y2) / 2;
        int num = array[xMid][yMid];
        if (num == target) {
            return true;
        }
        if (num > target) {
            if (binarySearch(array, x1, xMid, y1, y2, target)) return true;
            if (binarySearch(array, xMid, x2, y1, yMid, target)) return true;
        } else {
            if (binarySearch(array, xMid + 1, x2, y1, y2, target)) return true;
            if (binarySearch(array, x1, xMid + 1, yMid + 1, y2, target)) return true;
        }
        return false;
    }

    public static boolean find(int target, int[][] array) {
        if (array.length == 0) {
            return false;
        }
        return binarySearch(array, 0, array.length, 0, array[0].length, target);
    }
}