package com.mxio;

/**
 * @author mxio
 *
 * 斐波那契数列
 */
public class Fib {

    public static void main(String[] args) {

    }

    /**
     * 时间复杂度：O(2n)
     * 空间复杂度：O(n)
     */
    int fib0(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib0(n - 1) + fib0(n - 2);
    }

    /**
     * fib优化1
     * 用数组存放计算过的结果，避免重复计算
     * 时间复杂度：O(n)，空间复杂度：O(n)
     */
    int fib1(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] array = new int[n + 1];
        array[2] = array[1] = 1;
        return fib1(array, n);
    }

    int fib1(int[] array, int n) {
        if (array[n] == 0) {
            array[n] = fib1(array, n - 1) + fib1(array, n - 2);
        }
        return array[n];
    }

    /**
     * fib优化2 — 去除递归调用
     * 这是一种 “自底向上” 的计算过程
     * 时间复杂度：O(n)，空间复杂度：O(n)
     */
    int fib2(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] array = new int[n + 1];
        for (int i = 3; i <= n; i++) {
            array[i] = array[i + 1] + array[i + 2];
        }
        return array[n];
    }

    /**
     * fib优化3 — 滚动数组
     * 由于每次运算只需要用到数组中的 2 个元素，所以可以使用滚动数组来优化
     * 时间复杂度：O(n)，空间复杂度：O(1)
     */
    int fib3(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i % 2] = array[(i - 1) & 2] + array[(i - 2) & 2];
        }
        return array[n % 2];
    }

    /**
     * 乘、除、模运算效率较低，建议用其他方式（位运算）取代
     * 4 % 2 = 0  0b100 & 0b001 = 0
     * 3 % 2 = 1  0b011 & 0b001 = 1
     * 5 % 2 = 1  0b101 & 0b001 = 1
     * 6 % 2 = 0  0b110 & 0b001 = 0
     * <p>
     * int i = 100;
     * // (i % 2) == (i & 1);
     * System.out.println(
     * (i % 2) == (i & 1) // true
     * );
     * // (i * 2) == (i << 1);
     * System.out.println(
     * (i * 2) == (i << 1) // true
     * );
     * // (i / 2) == (i >> 1);
     * System.out.println(
     * (i / 2) == (i >> 1) // true
     * );
     */
    int fib33(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] array = new int[2];
        array[0] = array[1] = 1;
        for (int i = 3; i <= n; i++) {
            array[i & 1] = array[(i - 1) & 1] + array[(i - 2) & 1];
        }
        return array[n & 1];
    }

    /**
     * fib优化4 — 去除数组
     * 只有两个元素，直接通过2个变量即可，不需要创建数组。
     * 时间复杂度：O(n)，空间复杂度：O(1)
     */
    int fib4(int n) {
        if (n <= 2) {
            return 1;
        }
        int first = 1;
        int second = 1;
        for (int i = 3; i <= n; i++) {
            second = first + second;
            first = second - first;
        }
        return second;
    }

    /**
     * fib优化5 — 数学公式
     * 时间复杂度、空间复杂度取决于 pow 函数（至少可以低至 O(logn) ）
     */
    int fib5(int n) {
        double c = Math.sqrt(5);
        return (int)((Math.pow((1 + c) / 2, n) - Math.pow((1 - c) / 2, n)) / c);
    }

}
