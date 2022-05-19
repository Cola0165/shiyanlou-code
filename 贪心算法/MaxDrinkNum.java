public class MaxDrinkNum {
    public static void main(String[] args) {
        System.out.println("有12瓶酒最多能喝:" + drink(12, 3));
    }

    public static int drink(int m, int n) {
        // 喝掉的酒
        int drinkedNum = m;
        // 空瓶
        int emptyNum = m;
        // 直到不够兑换
        while ((emptyNum / n) != 0) {
            // 兑换的酒
            int transferNum = emptyNum / n;
            // 喝掉
            drinkedNum += transferNum;
            // 空瓶
            emptyNum = transferNum + emptyNum % n;
        }
        return drinkedNum;
    }
}