package com.greedy;

public class MaxExperienceValue {
    public static void main(String[] args) {
        System.out.println(getMaxValue(10, 5, 5, 3));
        System.out.println(getMaxValue(10, 5, 5, 5));
        System.out.println(getMaxValue(30, 5, 5, 100));
    }

    public static long getMaxValue(long x, long a, long b, long n) {
        // 推导出来的导数
        long restTime = (2 * b * n + 2 * a * n - 2 * x - a) / (4 * b + 2 * a);
        long result1 = sum(restTime, x, a, b, n);
        long result2 = sum(restTime + 1, x, a, b, n);

        return Math.max(result1, result2);
    }

    public static long sum(long relaxTime, long x, long a, long b, long n) {
        return (n - relaxTime) * (x + b * relaxTime + x + b * relaxTime - a * (n - 1 - relaxTime)) / 2;
    }
}