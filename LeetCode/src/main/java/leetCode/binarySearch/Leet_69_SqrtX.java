package leetCode.binarySearch;

/**
 * leetcode 69 x的平方根
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class Leet_69_SqrtX {

    /**
     * 二分法，区间初始为0到x,每次取中间值的平方与x比较
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 0, right = x, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = 1l * mid * mid;
            if (square <= x) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Leet_69_SqrtX intance = new Leet_69_SqrtX();
        System.out.println(intance.mySqrt(2147395599));
    }
}
